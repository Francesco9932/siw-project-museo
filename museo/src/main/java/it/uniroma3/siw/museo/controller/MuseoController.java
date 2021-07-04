package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class MuseoController {
	@Autowired
	private MuseoService museoService;

	@RequestMapping(value="/collezioni",method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni",museoService.getCollezioni());
		return "collezioni.html";
	}

	@RequestMapping(value="/informazioni",method = RequestMethod.GET)
	public String getInformazioni() {
		return "informazioni.html";
	}

	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("opere",museoService.getOpere());
		return "index.html";
	}
}
