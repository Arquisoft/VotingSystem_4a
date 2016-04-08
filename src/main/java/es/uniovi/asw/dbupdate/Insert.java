package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.ElectionCall;
import es.uniovi.asw.util.ParametersException;

/**
 * Insert
 * Created by ivan on 1/04/16.
 */
public interface Insert {

	void insertElectionCall(ElectionCall electionCall) throws ParametersException;

	void insertElection(Long idElectionCall, Election election) throws ParametersException;



}
