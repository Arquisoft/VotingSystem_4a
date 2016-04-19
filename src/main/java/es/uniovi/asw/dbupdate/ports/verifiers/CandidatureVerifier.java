package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.util.ParametersException;

/**
 * CandidatureVerifier
 * Created by ivan on 17/04/16.
 */
public class CandidatureVerifier {

	public static void verify(Candidature candidature) throws ParametersException {

		if (candidature == null) {
			throw new ParametersException("La candidatura no existe o está vacía");
		}

	}

}
