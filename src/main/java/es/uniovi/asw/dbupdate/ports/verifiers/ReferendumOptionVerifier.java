package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.ReferendumOptionRepository;
import es.uniovi.asw.model.ReferendumOption;
import es.uniovi.asw.util.ParametersException;

/**
 * RegionVerifier
 * Created by ivan on 15/04/16.
 */
public class ReferendumOptionVerifier {

	public static void verify(ReferendumOption referendumOption, ReferendumOptionRepository referendumOptionRepository) throws ParametersException {

		if (referendumOption == null) {
			throw new ParametersException("La opción de referéndum está vacía");
		}

		if (referendumOption.getOption() == null || referendumOption.getOption().equals("")) {
			throw new ParametersException("La opción de referéndum debe tener un nombre");
		}

		if (referendumOptionRepository.findByOption(referendumOption.getOption()) != null) {
			throw new ParametersException("Ya hay registrada una opción de referéndum con el mismo nombre");
		}

	}

}
