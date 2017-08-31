package com.sopra.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sopra.model.Tetrimino;

public class AddTetriminoValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Tetrimino.class.equals(cls);
	}

	@Override
	public void validate(Object arg0, Errors e) {
	}

	public void validate(Tetrimino myTetrimino, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nameTetrimino", "check.nameTetrimino");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "colourTetrimino", "check.colourTetrimino");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "coef", "check.coefTetrimino");
	}
}
