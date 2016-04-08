package es.uniovi.asw.dbupdate.ports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.dbupdate.GetVoter;
import es.uniovi.asw.dbupdate.ports.verifiers.VoterVerifier;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.VoterException;

/**
 * GetVoterP
 * Created by ivan on 2/04/16.
 */
@Service
public class GetVoterP implements GetVoter{
	
	@Autowired
	private VoterRepository voterRepository;

	@Override
	public void insertVoter(Voter voter) throws VoterException {
		
		VoterVerifier.verify(voter, voterRepository);
		voterRepository.save(voter);
		
	}

}
