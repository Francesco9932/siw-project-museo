package it.uniroma3.siw.museo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.controller.validator.ArtistaValidator;
import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class ArtistaController {

	@Autowired
	private MuseoService museoService;

	@Autowired 
	private ArtistaValidator artistaValidator;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/admin/addArtista", method = RequestMethod.GET)
	public String addArtista(Model model) {
		logger.debug("addArtista");
		model.addAttribute("artista", new Artista());
		return "artistaForm.html";
	}

	@RequestMapping(value = "/admin/artista", method = RequestMethod.POST)
	public String newPersona(@ModelAttribute("artista") Artista artista, 
			Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista,bindingResult);
		if(!bindingResult.hasErrors()) {
			this.museoService.aggiungiArtista(artista);
			return "index.html";
		}
		return "artistaForm.html";
	}
	
	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	public String getArtisti(Model model) {
		model.addAttribute("artisti",this.museoService.getArtisti());
		return "autori.html";
	}
	
	@RequestMapping(value = "/artista/{id}", method = RequestMethod.GET)
	public String getArtista(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artista",this.museoService.getArtistaPerId(id));
		return "artista.html";
	}

	@RequestMapping(value = "/removeArtista/{id}", method = RequestMethod.GET)
	public String removeArtista(@PathVariable("id") Long id, Model model) {
		this.museoService.rimuoviArtista(id);
		return "index.html";
	}
}
