package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ParametersException;

/**
 * VoterVerifier
 * Created by ivan on 8/04/16.
 */
public class VoterVerifier {

	public static void verify(Voter voter, VoterRepository voterRepository) throws ParametersException {

		if (voter == null) {
			throw new ParametersException("El votante está vacío");
		}

		if (voter.getName() == null || voter.getName().equals("")) {
			throw new ParametersException("El votante debe tener un nombre");
		}

		if (voter.getNif() == null || voter.getNif().equals("")) {
			throw new ParametersException("El votante debe tener un NIF");
		}

		if (voter.getEmail() == null || voter.getEmail().equals("")) {
			throw new ParametersException("El votante debe tener un email");
		}

		if (voter.getCode() == null || voter.getCode() < 0) {
			throw new ParametersException("El colegio electoral del votante no es correcto");
		}

		if (voterRepository.findByNif(voter.getNif()) != null) {
			throw new ParametersException("Ya hay registrado un votante con el mismo NIF");
		}

	}

}
