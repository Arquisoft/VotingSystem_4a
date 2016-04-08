package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.VoteRepository;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.util.VoteException;

/**
 * VoteVerifier Created by Ricardo on 8/04/16.
 */
public class VoteVerifier {

	public static void verify(Vote vote, VoteRepository voteRepository) throws VoteException {

		if (vote == null) {
			throw new VoteException("El voto no existe.");
		}

		if (voteRepository.findOne(vote.getId()) != null) {
			throw new VoteException("Sólo puede haber un voto por votante.");
		}

		if (vote.getVotingPlace() == null || vote.getVotingPlace().equals("")) {
			throw new VoteException("El voto debe tener asignado un colegio electoral.");
		}

	}

}
