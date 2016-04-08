package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.model.Election;
import es.uniovi.asw.util.ParametersException;

/**
 * ElectionCallVerifier
 * Created by ivan on 8/04/16.
 */
public class ElectionVerifier {

	public static void verify(Election election, ElectionRepository electionRepository) throws ParametersException {

		if (election == null) {
			throw new ParametersException("La elección está vacía");
		}

		if (election.getName() == null || election.getName().equals("")) {
			throw new ParametersException("La elección debe tener un nombre");
		}

		if (election.getDescription() == null || election.getDescription().equals("")) {
			throw new ParametersException("La elección debe tener una descripción");
		}

		if (electionRepository.findByName(election.getName()) != null) {
			throw new ParametersException("Ya hay registrada una elección con el mismo nombre");
		}

		if (electionRepository.findByElectionDateTime(election.getElectionDateTime()) != null) {
			throw new ParametersException("Ya hay registrada una elección en la misma fecha");
		}

	}

}
