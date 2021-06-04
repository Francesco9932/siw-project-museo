package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class CollezioneController {
	@Autowired
	private MuseoService museoService;
	
	@Autowired 
	private CollezioneValidator collezioneValidator;
	
	//tofix
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model){
		model.addAttribute("opera",new Opera());
		return "operaForm.html";
	}
}
