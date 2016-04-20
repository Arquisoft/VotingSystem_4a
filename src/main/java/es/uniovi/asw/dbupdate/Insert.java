package es.uniovi.asw.dbupdate;

import es.uniovi.asw.model.*;
import es.uniovi.asw.util.ParametersException;

/**
 * Insert
 * Created by ivan on 1/04/16.
 */
public interface Insert {

	ElectionCall insertElectionCall(ElectionCall electionCall) throws ParametersException;

	Election insertElection(Long idElectionCall, Election election) throws ParametersException;

	Region insertRegion(Long idElection, Region region) throws ParametersException;

	District insertDistrict(Long idRegion, District district) throws ParametersException;

	ReferendumOption insertReferendumOption(Long idDistrict, ReferendumOption referendumOption) throws ParametersException;

	VotingPlace insertVotingPlace(Long idDistrict, VotingPlace votingPlace) throws ParametersException;

	Voter insertVoter(Long idVotingPlace, Voter voter) throws ParametersException;

}
