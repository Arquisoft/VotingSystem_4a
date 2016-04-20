package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.ports.verifiers.*;
import es.uniovi.asw.dbupdate.repositories.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.util.ParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InsertP
 * Created by ivan on 2/04/16.
 */
@Service
public class InsertP implements Insert {

	@Autowired
	private ElectionCallRepository electionCallRepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private CandidatureRepository candidatureRepository;

	@Autowired
	private VotingPlaceRepository placeRepository;

	@Autowired
	private VoterRepository voterRepository;


	@Override
	public ElectionCall insertElectionCall(ElectionCall electionCall) throws ParametersException {
		ElectionCallVerifier.verify(electionCall);
		return electionCallRepository.save(electionCall);
	}

	@Override
	public Election insertElection(Long idElectionCall, Election election) throws ParametersException {

		if (idElectionCall == null) {
			throw new ParametersException("El id de la convocatoria electoral es nulo");
		}

		ElectionVerifier.verify(election);

		ElectionCall electionCall = electionCallRepository.findOne(idElectionCall);
		ElectionCallVerifier.verify(electionCall);

		electionCall.addElection(election);
		return electionRepository.save(election);
	}

	@Override
	public Region insertRegion(Long idElection, Region region) throws ParametersException {

		if (idElection == null) {
			throw new ParametersException("El id de elección es nulo");
		}

		RegionVerifier.verify(region);

		Election election = electionRepository.findOne(idElection);
		ElectionVerifier.verify(election);

		election.addRegion(region);
		return regionRepository.save(region);
	}

	@Override
	public District insertDistrict(Long idRegion, District district) throws ParametersException {

		if (idRegion == null) {
			throw new ParametersException("El id de región es nulo");
		}

		DistrictVerifier.verify(district);

		Region region = regionRepository.findOne(idRegion);
		RegionVerifier.verify(region);

		region.addDistrict(district);
		return districtRepository.save(district);
	}

	@Override
	public ReferendumOption insertReferendumOption(Long idDistrict, ReferendumOption referendumOption) throws ParametersException {

		if (idDistrict == null) {
			throw new ParametersException("El id de circunscripción es nulo");
		}

		ReferendumOptionVerifier.verify(referendumOption);

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		district.addCandidature(referendumOption);
		return candidatureRepository.save(referendumOption);
	}

	@Override
	public VotingPlace insertVotingPlace(Long idDistrict, VotingPlace votingPlace) throws ParametersException {

		if (idDistrict == null) {
			throw new ParametersException("El id de circunscripción es nulo");
		}

		VotingPlaceVerifier.verify(votingPlace);

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		district.addVotingPlace(votingPlace);
		return placeRepository.save(votingPlace);
	}

	@Override
	public Voter insertVoter(Long idVotingPlace, Voter voter) throws ParametersException {

		if (idVotingPlace == null) {
			throw new ParametersException("El id del colegio electoral es nulo");
		}

		VoterVerifier.verify(voter);

		VotingPlace votingPlace = placeRepository.findOne(idVotingPlace);
		VotingPlaceVerifier.verify(votingPlace);

		votingPlace.addVoter(voter);
		return voterRepository.save(voter);
	}

}
