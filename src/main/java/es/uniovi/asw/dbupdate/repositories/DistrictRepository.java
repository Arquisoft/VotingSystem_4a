package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.District;
import org.springframework.data.repository.CrudRepository;

/**
 * DistrictRepository
 * Created by ivan on 1/04/16.
 */
public interface DistrictRepository extends CrudRepository<District, Long> {

	District findByName(String name);

}
