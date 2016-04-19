package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.ReferendumOption;
import es.uniovi.asw.util.ParametersException;

/**
 * ReferendumOptionVerifier
 * Created by ivan on 15/04/16.
 */
public class ReferendumOptionVerifier {

	public static void verify(ReferendumOption referendumOption) throws ParametersException {

		if (referendumOption == null) {
			throw new ParametersException("La opción de referéndum no existe");
		}

		if (referendumOption.getOption() == null || referendumOption.getOption().equals("")) {
			throw new ParametersException("La opción de referéndum debe tener un nombre");
		}

	}

}
