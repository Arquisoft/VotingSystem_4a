package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.GetParameters;
import es.uniovi.asw.dbupdate.ports.verifiers.DistrictVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.ElectionCallVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.ElectionVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.RegionVerifier;
import es.uniovi.asw.dbupdate.repositories.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.util.ParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GetParametersP
 * Created by ivan on 2/04/16.
 */
@Service
public class GetParametersP implements GetParameters {

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


	@Override
	public Iterable<ElectionCall> getElectionCalls() throws ParametersException {
		return electionCallRepository.findAll();
	}

	@Override
	public Iterable<Election> getElections(Long idElectionCall) throws ParametersException {

		if (idElectionCall == null) {
			throw new ParametersException("El id de la convocatoria electoral es nulo");
		}

		ElectionCall electionCall = electionCallRepository.findOne(idElectionCall);
		ElectionCallVerifier.verify(electionCall);

		return electionRepository.findByElectionCall(electionCall);

	}

	@Override
	public Iterable<Region> getRegions(Long idElection) throws ParametersException {

		if (idElection == null) {
			throw new ParametersException("El id de elección es nulo");
		}

		Election election = electionRepository.findOne(idElection);
		ElectionVerifier.verify(election);

		return regionRepository.findByElection(election);

	}

	@Override
	public Iterable<District> getDistricts(Long idRegion) throws ParametersException {

		if (idRegion == null) {
			throw new ParametersException("El id de región es nulo");
		}

		Region region = regionRepository.findOne(idRegion);
		RegionVerifier.verify(region);

		return districtRepository.findByRegion(region);
	}

	@Override
	public Iterable<ReferendumOption> getCandidatures(Long idDistrict) throws ParametersException {

		if (idDistrict == null) {
			throw new ParametersException("El id de circunscripción es nulo");
		}

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		return candidatureRepository.findByDistrict(district);
	}

	@Override
	public Iterable<VotingPlace> getVotingPlaces(Long idDistrict) throws ParametersException {

		if (idDistrict == null) {
			throw new ParametersException("El id de circunscripción es nulo");
		}

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district);

		return placeRepository.findByDistrict(district);
	}
}
