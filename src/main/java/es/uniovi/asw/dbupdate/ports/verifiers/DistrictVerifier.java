package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.District;
import es.uniovi.asw.util.ParametersException;

/**
 * DistrictVerifier
 * Created by ivan on 15/04/16.
 */
public class DistrictVerifier {

	public static void verify(District district) throws ParametersException {

		if (district == null) {
			throw new ParametersException("La circunscripción no existe");
		}

		if (district.getName() == null || district.getName().equals("")) {
			throw new ParametersException("La circunscripción debe tener un nombre");
		}

	}

}
