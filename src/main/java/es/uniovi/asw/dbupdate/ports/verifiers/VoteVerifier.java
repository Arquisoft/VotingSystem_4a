package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.util.ParametersException;

/**
 * VoteVerifier
 * Created by ivan on 19/04/16.
 */
public class VoteVerifier {

	public static void verify(Long idCandidature, Long idVotingPlace) throws ParametersException {

		if (idCandidature == null) {
			throw new ParametersException("La candidatura VoteVerifier");
		}

		if (idVotingPlace == null) {
			throw new ParametersException("El colegio electoral VoteVerifier");
		}

	}

}
