package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.VoterException;

/**
 * GetVoter
 * Created by Ricardo on 8/04/16.
 */
public interface GetVoter {
	
	void insertVoter(Voter voter) throws VoterException;

}
