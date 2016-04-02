package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * VoteRepository
 * Created by ivan on 1/04/16.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {

}
