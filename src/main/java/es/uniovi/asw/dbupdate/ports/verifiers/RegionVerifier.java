package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.RegionRepository;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.util.ParametersException;

/**
 * RegionVerifier
 * Created by ivan on 15/04/16.
 */
public class RegionVerifier {

	public static void verify(Region region, RegionRepository regionRepository) throws ParametersException {

		if (region == null) {
			throw new ParametersException("La región está vacía");
		}

		if (region.getName() == null || region.getName().equals("")) {
			throw new ParametersException("La región debe tener un nombre");
		}

		if (regionRepository.findByName(region.getName()) != null) {
			throw new ParametersException("Ya hay registrada una región con el mismo nombre");
		}

	}

}
