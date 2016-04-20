package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.ElectionCall;
import es.uniovi.asw.model.types.ElectionDateTime;
import org.springframework.data.repository.CrudRepository;

/**
 * ElectionRepository
 * Created by ivan on 1/04/16.
 */
public interface ElectionRepository extends CrudRepository<Election, Long> {

	Election findByName(String name);

	Iterable<Election> findByElectionCall(ElectionCall idElectionCall);

	Election findByElectionDateTime(ElectionDateTime electionDateTime);

}
