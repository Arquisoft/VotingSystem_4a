package es.uniovi.asw.util;

import es.uniovi.asw.dbupdate.ports.GetVoterP;
import es.uniovi.asw.model.Voter;

public class Login {

	public Object auth(String email, String password) throws ParametersException {

		if (email.equals("junta@electoral.es") && password.equals("admin")) {
			return "admin";
		}

		else {

			GetVoterP getVoterP = new GetVoterP();
			Voter voter = getVoterP.getVoterByEmail(email);

			if (voter.getPassword().equals(password)) {
				return voter;
			} else {
				return null;
			}
		}

	}

}
