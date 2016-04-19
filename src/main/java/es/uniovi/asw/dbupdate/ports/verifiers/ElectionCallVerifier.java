package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.ElectionCall;
import es.uniovi.asw.util.ParametersException;

/**
 * ElectionCallVerifier
 * Created by ivan on 8/04/16.
 */
public class ElectionCallVerifier {

	public static void verify(ElectionCall electionCall) throws ParametersException {

		if (electionCall == null) {
			throw new ParametersException("La elección no existe");
		}

		if (electionCall.getName() == null || electionCall.getName().equals("")) {
			throw new ParametersException("La convocatoria electoral debe tener un nombre");
		}

		if (electionCall.getDescription() == null || electionCall.getDescription().equals("")) {
			throw new ParametersException("La convocatoria electoral debe tener una descripción");
		}

	}

}
