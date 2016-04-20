package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.District;
import es.uniovi.asw.model.VotingPlace;
import org.springframework.data.repository.CrudRepository;

/**
 * VotingPlaceRepository
 * Created by ivan on 1/04/16.
 */
public interface VotingPlaceRepository extends CrudRepository<VotingPlace, Long> {

	VotingPlace findByName(String name);

	Iterable<VotingPlace> findByDistrict(District idDistrict);

}
