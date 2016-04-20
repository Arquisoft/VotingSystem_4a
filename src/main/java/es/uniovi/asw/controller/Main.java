package es.uniovi.asw.controller;

import java.util.Collection;

import es.uniovi.asw.dbupdate.ports.GetParametersP;
import es.uniovi.asw.util.Login;
import es.uniovi.asw.util.ParametersException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.model.District;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.model.Voter;

@Controller
public class Main {

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private GetParametersP getParametersP;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView landing(Model model) {
		logger.info("Index page access");
		model.addAttribute("voter", new Voter());

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="email") String email,
	                          @RequestParam(value="password") String password, Model model) {
		logger.info("Login");

		try {

			Login login = new Login();
			Object loginData = login.auth(email, password);

			if (loginData == null) {
				logger.info("User/pass incorrect");
				model.addAttribute("error", "Usuario y/o password incorrectos");
				return new ModelAndView("index");
			}

			else if (loginData instanceof Voter) {
				logger.info("Login Usuario " + ((Voter) loginData).getName());
				model.addAttribute("voter", loginData);
				model.addAttribute("elecciones", getParametersP.getElections(1L));
				return new ModelAndView("index-voter");
			}

			else if (loginData instanceof String) {
				logger.info("Login Junta Electoral");
				return new ModelAndView("index-electoral-board");
			}

		}

		catch (ParametersException e) {
			logger.info("ERROR: " + e.getMessage());
			model.addAttribute("error", e.getMessage());
		}

		return new ModelAndView("index");

	}

	@RequestMapping("candidaturas/{id}")
	public String showCandidaturas(@PathVariable Long id, Model model) {

		Region r = (Region) electionRepository.findOne(id).getRegions().toArray()[0];
		District circunscripcion = (District) r.getDistricts().toArray()[0];
		Collection<Candidature> candidaturas = circunscripcion.getCandidatures();
		model.addAttribute("candidaturas", candidaturas);

		return "candidaturas";
	}

}