package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ParametersException;

/**
 * GetVoter
 * Created by ivan on 2/04/16.
 */
public interface GetVoter {

	Voter getVoter(Long idVoter) throws ParametersException;
}
