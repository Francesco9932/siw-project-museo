package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.controller.validator.CuratoreValidator;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class CuratoreController {
	@Autowired
	private MuseoService museoService;

	@Autowired 
	private CuratoreValidator curatoreValidator;

	@RequestMapping(value = "/admin/addCuratore", method = RequestMethod.GET)
	public String addCuratore(Model model) {
		model.addAttribute("curatore", new Curatore());
		return "curatoreForm.html";
	}

	@RequestMapping(value = "/admin/curatore", method = RequestMethod.POST)
	public String newPersona(@ModelAttribute("curatore") Curatore curatore, 
			Model model, BindingResult bindingResult) {
		this.curatoreValidator.validate(curatore,bindingResult);
		if(!bindingResult.hasErrors()) {
			this.museoService.aggiungiCuratore(curatore);
			return "index.html";
		}
		return "curatoreForm.html";
	}
}
