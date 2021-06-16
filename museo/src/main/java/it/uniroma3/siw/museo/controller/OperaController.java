package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class OperaController {
	
	@Autowired
	private MuseoService museoService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		logger.debug("addOpera");
		model.addAttribute("opera", new Opera());
		return "operaForm.html";
	}
	
	@RequestMapping(value = "/opera", method = RequestMethod.POST)
	public String newOpera(@ModelAttribute("opera") Opera opera, 
			Model model) {
		this.museoService.aggiungiOpera(opera);
		return "index.html";
	}
}