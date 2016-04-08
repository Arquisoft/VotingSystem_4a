package es.uniovi.asw.dbupdate.ports.verifiers;

import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.util.VoterException;

public class VoterVerifier {

	public static void verify(Voter v, VoterRepository r) throws VoterException {

		if (v == null) {
			throw new VoterException("El votante no existe.");
		}

		if (v.isVoted()) {
			throw new VoterException("Este usuario ya ha votado.");
		}

		if (v.getNif() == null || v.getNif().equals("")) {
			throw new VoterException("Usuario con dni no asignado");
		}

	}

}
