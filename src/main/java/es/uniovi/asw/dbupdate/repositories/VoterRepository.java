package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Voter;
import org.springframework.data.repository.CrudRepository;

/**
 * VoterRepository
 * Created by ivan on 1/04/16.
 */
public interface VoterRepository extends CrudRepository<Voter, Long> {

	Voter findByNif(String nif);

	Voter findByEmail(String email);

}
