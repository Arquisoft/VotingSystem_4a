package es.uniovi.asw.util;

import es.uniovi.asw.dbupdate.GetParameters;
import es.uniovi.asw.dbupdate.GetVoter;
import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.RegisterVote;
import es.uniovi.asw.dbupdate.ports.GetParametersP;
import es.uniovi.asw.dbupdate.ports.GetVoterP;
import es.uniovi.asw.dbupdate.ports.InsertP;
import es.uniovi.asw.dbupdate.ports.RegisterVoteP;

/**
 * ServicesFactory
 * @author ivan
 */
public class ServicesFactory {

	public static Insert getDBUpdateInsertService() {
		return new InsertP();
	}

	public static GetVoter getDBUpdateGetVoterService() {
		return new GetVoterP();
	}

	public static RegisterVote getDBUpdateRegisterVoteService() {
		return new RegisterVoteP();
	}

	public static GetParameters getDBUpdateGetParametersService() {
		return new GetParametersP();
	}

}
