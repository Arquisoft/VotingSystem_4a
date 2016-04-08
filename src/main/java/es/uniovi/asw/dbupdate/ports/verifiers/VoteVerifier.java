package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.Vote;
import es.uniovi.asw.util.VoteException;

/**
 * VoteVerifier Created by Ricardo on 8/04/16.
 */
public class VoteVerifier {

	public static void verify(Vote vote) throws VoteException {

		if (vote == null) {
			throw new VoteException("El voto no existe.");
		}

	}

}
