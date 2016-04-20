package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.Region;
import org.springframework.data.repository.CrudRepository;

/**
 * RegionRepository
 * Created by ivan on 1/04/16.
 */
public interface RegionRepository extends CrudRepository<Region, Long> {

	Region findByName(String name);

	Iterable<Region> findByElection(Election idElection);

}
