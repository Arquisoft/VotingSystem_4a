package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.ports.verifiers.*;
import es.uniovi.asw.dbupdate.repositories.*;
import es.uniovi.asw.model.*;
import es.uniovi.asw.util.ParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	@Qualifier("candidatureRepository")

	@Autowired
	private CandidatureRepository candidatureRepository;


	@Override
	public void insertElectionCall(ElectionCall electionCall) throws ParametersException {
		ElectionCallVerifier.verify(electionCall, electionCallRepository);
		electionCallRepository.save(electionCall);
	}

	@Override
	public void insertElection(Long idElectionCall, Election election) throws ParametersException {
		ElectionVerifier.verify(election, electionRepository);

		ElectionCall electionCall = electionCallRepository.findOne(idElectionCall);
		ElectionCallVerifier.verify(electionCall, electionCallRepository);

		electionCall.addElection(election);
		electionCallRepository.save(electionCall);
	}

	public void insertRegion(Long idElection, Region region) throws ParametersException {
		RegionVerifier.verify(region, regionRepository);

		Election election = electionRepository.findOne(idElection);
		ElectionVerifier.verify(election, electionRepository);

		election.addRegion(region);
		electionRepository.save(election);
	}

	public void insertDistrict(Long idRegion, District district) throws ParametersException {
		DistrictVerifier.verify(district, districtRepository);

		Region region = regionRepository.findOne(idRegion);
		RegionVerifier.verify(region, regionRepository);

		region.addDistrict(district);
		regionRepository.save(region);
	}

	public void insertReferendumOption(Long idDistrict, ReferendumOption referendumOption) throws ParametersException {
		ReferendumOptionVerifier.verify(referendumOption, candidatureRepository);

		District district = districtRepository.findOne(idDistrict);
		DistrictVerifier.verify(district, districtRepository);

		district.addCandidature(referendumOption);
		districtRepository.save(district);
	}
}
