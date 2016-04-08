package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.ElectionCall;
import org.springframework.data.repository.CrudRepository;

/**
 * ElectionCallRepository
 * Created by ivan on 1/04/16.
 */
public interface ElectionCallRepository extends CrudRepository<ElectionCall, Long> {

	ElectionCall findByName(String name);

}
