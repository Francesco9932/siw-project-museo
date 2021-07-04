package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.controller.validator.OperaValidator;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class OperaController {
	
	@Autowired
	private MuseoService museoService;
	
	@Autowired
	private OperaValidator operaValidator;
	
	@RequestMapping(value = "/admin/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		model.addAttribute("opera", new Opera());
		model.addAttribute("artisti",museoService.getArtisti());
		model.addAttribute("collezioni",museoService.getCollezioni());
		return "operaForm.html";
	}
	
	@RequestMapping(value = "/admin/opera", method = RequestMethod.POST)
	public String newOpera(@ModelAttribute("opera") Opera opera, 
			Model model, BindingResult bindingResult) {
		this.operaValidator.validate(opera,bindingResult);
		if(!bindingResult.hasErrors()) {
			this.museoService.aggiungiOpera(opera);
			return "index.html";
		}
		return "operaForm.html";
	}
	
	@RequestMapping(value="/opera/{id}", method=RequestMethod.GET)
	public String getOpera(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera",this.museoService.getOperaPerId(id));
		return "opera.html";
	}
	
	@RequestMapping(value="/admin/rimuoviOpera", method = RequestMethod.GET)
	public String getOpereDaRimuovere(Model model){
		model.addAttribute("opere",this.museoService.getOpere());
		return "rimozioneOpera.html";
	}
	
	@RequestMapping(value="/admin/removeOpera/{id}",method = RequestMethod.GET)
	public String removeOpera(@PathVariable("id") Long id, Model model) {
		museoService.rimuoviOpera(id);
		return "index.html";
	}
}
