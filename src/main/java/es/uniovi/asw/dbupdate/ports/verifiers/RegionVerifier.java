package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.model.Region;
import es.uniovi.asw.util.ParametersException;

/**
 * RegionVerifier
 * Created by ivan on 15/04/16.
 */
public class RegionVerifier {

	public static void verify(Region region) throws ParametersException {

		if (region == null) {
			throw new ParametersException("La región no existe");
		}

		if (region.getName() == null || region.getName().equals("")) {
			throw new ParametersException("La región debe tener un nombre");
		}

	}

}
