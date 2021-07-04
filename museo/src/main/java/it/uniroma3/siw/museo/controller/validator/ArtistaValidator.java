package it.uniroma3.siw.museo.controller.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.service.MuseoService;


@Component
public class ArtistaValidator implements Validator {
	@Autowired
	private MuseoService museoService;

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazionalita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "immagine", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");

		if (!errors.hasErrors()) {
			if (this.museoService.alreadyExists((Artista)o)) {
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Artista.class.equals(aClass);
	}
}
