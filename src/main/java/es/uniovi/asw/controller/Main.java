package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping("/")
	public ModelAndView landing(Model model) {
		logger.info("Index page access");
		return new ModelAndView("index");
	}

}