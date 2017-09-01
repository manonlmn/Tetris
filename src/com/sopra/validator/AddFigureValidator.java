package com.sopra.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sopra.model.Figure;

public class AddFigureValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Figure.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
	}
	
	public void validate(Figure myFigure, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "rotationNumber", "check.rotationNumber");
	}
	

}
