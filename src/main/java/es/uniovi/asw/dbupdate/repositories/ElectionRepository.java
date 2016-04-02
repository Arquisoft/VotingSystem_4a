package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Election;
import org.springframework.data.repository.CrudRepository;

/**
 * ElectionRepository
 * Created by ivan on 1/04/16.
 */
public interface ElectionRepository extends CrudRepository<Election, Long> {

}
