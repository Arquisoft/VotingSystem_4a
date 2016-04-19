package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.Election;
import es.uniovi.asw.util.ParametersException;

/**
 * ElectionVerifier
 * Created by ivan on 8/04/16.
 */
public class ElectionVerifier {

	public static void verify(Election election) throws ParametersException {

		if (election == null) {
			throw new ParametersException("La elección no existe");
		}

		if (election.getName() == null || election.getName().equals("")) {
			throw new ParametersException("La elección debe tener un nombre");
		}

		if (election.getDescription() == null || election.getDescription().equals("")) {
			throw new ParametersException("La elección debe tener una descripción");
		}

	}

}
