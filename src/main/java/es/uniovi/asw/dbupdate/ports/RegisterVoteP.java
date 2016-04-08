package es.uniovi.asw.dbupdate.ports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.dbupdate.RegisterVote;
import es.uniovi.asw.dbupdate.repositories.VoteRepository;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.util.VoteException;

/**
 * RegisterVoteP Created by Ricardo on 8/04/16.
 */
@Service
public class RegisterVoteP implements RegisterVote {

	@Autowired
	private VoteRepository voteRepository;

	@Override
	public void registerVote(Vote vote) throws VoteException {

		// No es necesario verificar el voto (confidencialidad)
		voteRepository.save(vote);

	}

}
