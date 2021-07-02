package it.uniroma3.siw.museo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.MuseoService;

@Component
public class OperaValidator implements Validator{
	@Autowired
	private MuseoService museoService;

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annoDiRealizzazione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "immagine", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artista", "required");

		if (!errors.hasErrors()) {
			if (this.museoService.alreadyExists((Opera)o)) {
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Artista.class.equals(aClass);
	}
}
