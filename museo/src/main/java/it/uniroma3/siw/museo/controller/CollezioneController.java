package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class CollezioneController {
	@Autowired
	private MuseoService museoService;
	
	@RequestMapping(value="/collezioni/{id}",method=RequestMethod.GET)
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artista",museoService.getCollezionePerId(id));
		return "collezioni.html";
	}
	
	@RequestMapping(value="/admin/addCollezione",method=RequestMethod.GET)
	public String addCollezione(Model model) {
		model.addAttribute("collezione",new Collezione());
		return "collezioneForm.html";
	}
	
	@RequestMapping(value="/admin/collezione",method=RequestMethod.POST)
	public String newCollezione(@ModelAttribute("collezione") Collezione collezione, Model model) {
		this.museoService.aggiungiCollezione(collezione);
		return "index.html";
	}
}
