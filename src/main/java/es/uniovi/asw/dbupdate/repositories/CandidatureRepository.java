package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Candidature;
import org.springframework.data.repository.CrudRepository;

/**
 * CandidatureRepository
 * Created by ivan on 2/04/16.
 */
public interface CandidatureRepository extends CrudRepository<Candidature, Long> {

	Candidature findByOption(String option);

}
