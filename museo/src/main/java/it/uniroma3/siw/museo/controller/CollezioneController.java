package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.controller.validator.CollezioneValidator;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class CollezioneController {
	@Autowired
	private MuseoService museoService;
	
	@Autowired
	private CollezioneValidator collezioneValidator;

	@RequestMapping(value="/collezioni/{id}",method=RequestMethod.GET)
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artista",museoService.getCollezionePerId(id));
		return "collezioni.html";
	}

	@RequestMapping(value="/admin/addCollezione",method=RequestMethod.GET)
	public String addCollezione(Model model) {
		model.addAttribute("collezione",new Collezione());
		model.addAttribute("curatori",museoService.getCuratori());
		return "collezioneForm.html";
	}

	@RequestMapping(value="/admin/collezione",method=RequestMethod.POST)
	public String newCollezione(@ModelAttribute("collezione") Collezione collezione, Model model, 
			BindingResult bindingResult) {
		this.collezioneValidator.validate(collezione, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.museoService.aggiungiCollezione(collezione);
			return "index.html";
		}
		return "collezioneForm.html";
	}

	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.GET)
	public String getArtista(@PathVariable("id") Long id, Model model) {
		model.addAttribute("collezione",this.museoService.getCollezionePerId(id));
		return "collezione.html";
	}
	
	@RequestMapping(value = "/admin/rimuoviCollezione", method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni",museoService.getCollezioni());
		return "rimozioneCollezione.html";
	}
	
	@RequestMapping(value = "/admin/rimuoviCollezione/{id}", method = RequestMethod.GET)
	public String removeCollezione(@PathVariable("id") Long id, Model model) {
		museoService.rimuoviCollezione(id);
		return "index.html";
	}
}
