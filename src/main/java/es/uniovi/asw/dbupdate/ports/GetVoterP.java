package es.uniovi.asw.dbupdate.ports;

import es.uniovi.asw.dbupdate.GetVoter;
import es.uniovi.asw.dbupdate.ports.verifiers.VoterVerifier;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.ParametersException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GetVoterP
 * Created by ivan on 2/04/16.
 */
@Service
public class GetVoterP implements GetVoter {

	@Autowired
	private VoterRepository voterRepository;

	@Override
	public Voter getVoter(Long idVoter) throws ParametersException {

		if (idVoter == null) {
			throw new ParametersException("El id de votante es nulo");
		}

		Voter voter = voterRepository.findOne(idVoter);
		VoterVerifier.verify(voter);

		return voter;
	}

	@Override
	public Voter getVoter(String nif) throws ParametersException {

		if (nif == null || nif.equals("")) {
			throw new ParametersException("El NIF del votante no es válido");
		}

		Voter voter = voterRepository.findByNif(nif);
		VoterVerifier.verify(voter);

		return voter;
	}

}
