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
	private VoteRepository voteRepository;

	@Autowired
	private VoterRepository voterRepository;


	@Override
	public ElectionCall insertElectionCall(ElectionCall electionCall) throws ParametersException {
		ElectionCallVerifier.verify(electionCall);
		return electionCallRepository.save(electionCall);
	}

	@Override
	public Election insertElection(Long idElectionCall, Election election) throws ParametersException {
		ElectionVerifier.verify(election);

		ElectionCall electionCall = electionCallRepository.findOne(idElectionCall);
		ElectionCallVerifier.verify(electionCall);

		electionCall.addElection(election);
		return electionRepository.save(election);
	}

	@Override
	public Region insertRegion(Long idElection, Region region) throws ParametersException {
		RegionVerifier.verify(region);

		Election election = electionRepository.findOne(idElection);
		ElectionVerifier.verify(election);

		election.addRegion(region);
		return regionRepository.save(region);
	}

	@Override
	public District insertDistrict(Long idRegion, District district) throws ParametersException {
		DistrictVerifier.verify(district);

		Region region = regionRepository.findOne(idRegion);
		RegionVerifier.verify(region);

		region.addDistrict(district);
		return districtRepository.save(district);
	}

	@Override
	public ReferendumOption insertReferendumOption(Long idDistrict, ReferendumOption referendumOption) throws ParametersException {
		ReferendumOptionVerifier.verify(referendumOption);

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		district.addCandidature(referendumOption);
		return candidatureRepository.save(referendumOption);
	}

	@Override
	public VotingPlace insertVotingPlace(Long idDistrict, VotingPlace votingPlace) throws ParametersException {
		VotingPlaceVerifier.verify(votingPlace);

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		district.addVotingPlace(votingPlace);
		return placeRepository.save(votingPlace);
	}

	@Override
	public Voter insertVoter(Long idVotingPlace, Voter voter) throws ParametersException {
		VoterVerifier.verify(voter);

		VotingPlace votingPlace = placeRepository.findOne(idVotingPlace);
		VotingPlaceVerifier.verify(votingPlace);

		votingPlace.addVoter(voter);
		return voterRepository.save(voter);
	}

	@Override
	public Vote insertVote(Long idCandidature, Long idVotingPlace) throws ParametersException {
		VoteVerifier.verify(idCandidature, idVotingPlace);

		VotingPlace votingPlace = placeRepository.findOne(idVotingPlace);
		VotingPlaceVerifier.verify(votingPlace);

		Candidature candidature = candidatureRepository.findOne(idCandidature);
		CandidatureVerifier.verify(candidature);

		Vote vote = new Vote(votingPlace, candidature);
		return voteRepository.save(vote);
	}

}
