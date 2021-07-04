package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.controller.validator.CredenzialiValidator;
import it.uniroma3.siw.museo.controller.validator.UserValidator;
import it.uniroma3.siw.museo.model.Credenziali;
import it.uniroma3.siw.museo.model.User;
import it.uniroma3.siw.museo.service.CredenzialiService;
import it.uniroma3.siw.museo.service.MuseoService;

@Controller
public class AuthenticationController {
	@Autowired
	private MuseoService museoService;
	
	@Autowired
	private CredenzialiService credenzialiService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private CredenzialiValidator credenzialiValidator;
	
	@RequestMapping(value = "/register", method =RequestMethod.GET)
	public String mostraRegistrazioneForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("credenziali", new Credenziali());
		return "registrazione.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String mostraLoginForm(Model model) {
		return "loginForm.html";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logut(Model model) {
		model.addAttribute("opere",museoService.getOpere());
		return "index.html";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
    public String defaultAfterLogin(Model model) {
        
    	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credenziali credenziali = credenzialiService.getCredenziali(userDetails.getUsername());
    	if (credenziali.getRuolo().equals(Credenziali.ADMIN_RUOLO)) {
    		model.addAttribute("opere",museoService.getOpere());
            return "admin/indexAdmin.html";
        }
    	model.addAttribute("opere",museoService.getOpere());
        return "index.html";
    }
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String registrazioneUser(@ModelAttribute("user") User user, BindingResult userBindingResult, 
			@ModelAttribute("credenziali") Credenziali credenziali, 
			BindingResult credenzialiBindingResult, Model model) {
		
		this.userValidator.validate(user, userBindingResult);
		this.credenzialiValidator.validate(credenziali, credenzialiBindingResult);

		if(!userBindingResult.hasErrors() && !credenzialiBindingResult.hasErrors()) {
			credenziali.setUser(user);
			credenzialiService.salvaCredenziali(credenziali);
			return "registrazioneEffettuata.html";
		}
		return "registrazione.html";
	}
}
