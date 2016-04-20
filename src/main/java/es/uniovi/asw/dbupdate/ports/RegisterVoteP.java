package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.RegisterVote;
import es.uniovi.asw.dbupdate.ports.verifiers.CandidatureVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.VoteVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.VoterVerifier;
import es.uniovi.asw.dbupdate.ports.verifiers.VotingPlaceVerifier;
import es.uniovi.asw.dbupdate.repositories.CandidatureRepository;
import es.uniovi.asw.dbupdate.repositories.VoteRepository;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.dbupdate.repositories.VotingPlaceRepository;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotingPlace;
import es.uniovi.asw.util.ParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RegisterVoteP
 * Created by ivan on 2/04/16.
 */
@Service
public class RegisterVoteP implements RegisterVote {

	@Autowired
	private CandidatureRepository candidatureRepository;

	@Autowired
	private VotingPlaceRepository placeRepository;

	@Autowired
	private VoterRepository voterRepository;

	@Autowired
	private VoteRepository voteRepository;

	@Override
	public Vote insertVote(Long idCandidature, Long idVotingPlace) throws ParametersException {

		if (idCandidature == null) {
			throw new ParametersException("El id de candidatura es nulo");
		}

		if (idVotingPlace == null) {
			throw new ParametersException("El id de colegio electoral es nulo");
		}

		VoteVerifier.verify(idCandidature, idVotingPlace);

		VotingPlace votingPlace = placeRepository.findOne(idVotingPlace);
		VotingPlaceVerifier.verify(votingPlace);

		Candidature candidature = candidatureRepository.findOne(idCandidature);
		CandidatureVerifier.verify(candidature);

		Vote vote = new Vote(votingPlace, candidature);
		return voteRepository.save(vote);
	}

	@Override
	public Voter registerVoter(String nif) throws ParametersException {

		if (nif == null || nif.equals("")) {
			throw new ParametersException("El NIF del votante no es válido");
		}

		Voter voter = voterRepository.findByNif(nif);
		VoterVerifier.verify(voter);

		voter.setVoted(true);
		return voterRepository.save(voter);
	}

}
