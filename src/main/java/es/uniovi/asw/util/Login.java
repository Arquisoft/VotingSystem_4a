package es.uniovi.asw.util;

import es.uniovi.asw.model.Voter;

public class Login {

	public static Object auth(String email, String password) throws ParametersException {

		if (email.equals("junta@electoral.es") && password.equals("admin")) {
			return "admin";
		}

		else {
			Voter voter = ServicesFactory.getDBUpdateGetVoterService().getVoterByEmail(email);

			if (voter.getPassword().equals(password)) {
				return voter;
			} else {
				return null;
			}
		}

	}

}
