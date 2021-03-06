package it.uniroma3.siw.museo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.MuseoService;

@Component
public class CollezioneValidator implements Validator {
	@Autowired
	private MuseoService museoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Collezione.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");

		if (!errors.hasErrors()) {
			if (this.museoService.alreadyExists((Collezione)target)) {
				errors.reject("duplicatoCollezione");
			}
		}
	}
	
}
