package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.dbupdate.repositories.ElectionRepository;
import es.uniovi.asw.model.Voter;

@Controller
public class Main {
	
	@Autowired
	private ElectionRepository electionRepository;

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView landing(Model model) {
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

}