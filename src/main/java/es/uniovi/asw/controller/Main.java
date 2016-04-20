package es.uniovi.asw.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.dbupdate.repositories.VoterRepository;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.model.District;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.model.Voter;

@Controller
public class Main {

	@Autowired
	private ElectionRepository electionRepository;

//	@Autowired
//	private VoterRepository voterRepository;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView landing(Model model, HttpSession session) {
		logger.info("Index page access");
		model.addAttribute("voter", new Voter());

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView adminIndex() {
		logger.info("Index junta electoral");

		return new ModelAndView("index-electoral-board");

	}

	@RequestMapping(value = "/", method = RequestMethod.POST, params = "get_cand")
	public ModelAndView showElections(Model model) {
		model.addAttribute("elecciones", electionRepository.findAll());
		return new ModelAndView("index-voter");
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