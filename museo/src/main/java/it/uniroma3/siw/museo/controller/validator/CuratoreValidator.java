package it.uniroma3.siw.museo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.service.MuseoService;

@Component
public class CuratoreValidator implements Validator{
	@Autowired
	private MuseoService museoService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Curatore.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoDiNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");

		if (!errors.hasErrors()) {
			if (this.museoService.alreadyExists((Curatore)o)) {
				errors.reject("duplicato");
			}
		}
	}
	
}
