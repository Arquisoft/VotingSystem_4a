package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.VotingPlaceRepository;
import es.uniovi.asw.model.VotingPlace;
import es.uniovi.asw.util.ParametersException;

/**
 * RegionVerifier
 * Created by ivan on 15/04/16.
 */
public class VotingPlaceVerifier {

	public static void verify(VotingPlace votingPlace, VotingPlaceRepository votingPlaceRepository) throws ParametersException {

		if (votingPlace == null) {
			throw new ParametersException("El colegio electoral está vacía");
		}

		if (votingPlace.getName() == null || votingPlace.getName().equals("")) {
			throw new ParametersException("El colegio electoral debe tener un nombre");
		}

		if (votingPlaceRepository.findByName(votingPlace.getName()) != null) {
			throw new ParametersException("Ya hay registrada un colegio electoral con el mismo nombre");
		}

	}

}
