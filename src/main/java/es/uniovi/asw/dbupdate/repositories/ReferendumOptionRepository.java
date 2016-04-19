package es.uniovi.asw.dbupdate.repositories;

import es.uniovi.asw.model.ReferendumOption;

/**
 * ReferendumOptionRepository
 * Created by ivan on 2/04/16.
 */
public interface ReferendumOptionRepository extends CandidatureRepository {

	ReferendumOption findByOption(String option);

}
