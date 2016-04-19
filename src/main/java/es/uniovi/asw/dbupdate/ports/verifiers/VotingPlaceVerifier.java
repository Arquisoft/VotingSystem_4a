package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.VotingPlace;
import es.uniovi.asw.util.ParametersException;

/**
 * VotingPlaceVerifier
 * Created by ivan on 15/04/16.
 */
public class VotingPlaceVerifier {

	public static void verify(VotingPlace votingPlace) throws ParametersException {

		if (votingPlace == null) {
			throw new ParametersException("El colegio electoral no existe");
		}

		if (votingPlace.getName() == null || votingPlace.getName().equals("")) {
			throw new ParametersException("El colegio electoral debe tener un nombre");
		}

	}

}
