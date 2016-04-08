package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Vote;
import es.uniovi.asw.util.VoteException;

/**
 * RegisterVote
 * Created by ivan on 2/04/16.
 */
public interface RegisterVote {
	
	void registerVote(Vote vote) throws VoteException;

}
