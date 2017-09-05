package com.sopra.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sopra.model.FAQ;
import com.sopra.model.Figure;

public class AddFAQValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return FAQ.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
	}

	public void validate(FAQ myFAQ, Errors e) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "myFAQ", "check.emptyRotationNumber");

	}
}
