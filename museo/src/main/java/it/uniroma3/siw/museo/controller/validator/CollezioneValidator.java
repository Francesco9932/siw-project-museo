package it.uniroma3.siw.museo.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.MuseoService;

@Component
public class CollezioneValidator implements Validator {
	private MuseoService museoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Collezione.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "curatore", "required");

		if (!errors.hasErrors()) {
			if (this.museoService.alreadyExists((Collezione)target)) {
				errors.reject("duplicato");
			}
		}
	}
	
}
