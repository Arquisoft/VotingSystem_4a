package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.ports.verifiers.ElectionCallVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.ElectionVerifier;
import es.uniovi.asw.dbupdate.repositories.ElectionCallRepository;
import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.ElectionCall;
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

}
