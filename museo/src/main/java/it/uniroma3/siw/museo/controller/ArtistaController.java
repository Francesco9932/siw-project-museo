package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class ArtistaController {
	@Autowired
	private MuseoService museoService;

	@Autowired 
	private ArtistaValidator artistaValidator;

	@RequestMapping(value = "/addArtista", method = RequestMethod.GET)
	public String addArtista(Model model){
		model.addAttribute("artista",new Artista());
		return "artistaForm.html";
	}

	@RequestMapping(value = "/getAutori", method = RequestMethod.GET)
	public String getArtistaPage(Model model){
		model.addAttribute("artisti",museoService.getArtisti());
		return "autori.html";
	}

	@RequestMapping(value = "/persona", method = RequestMethod.POST)
	public String newPersona(@ModelAttribute("persona") Artista artista, 
			Model model, BindingResult bindingResult) {
		this.museoService.aggiungiArtista(artista);
		model.addAttribute("persone", this.museoService.getArtisti());
		return "autori.html";
	}
}
