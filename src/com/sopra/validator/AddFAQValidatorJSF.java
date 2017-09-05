package com.sopra.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sopra.model.FAQ;

@FacesValidator("com.sopra.validator")
public class AddFAQValidatorJSF implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		FacesMessage myFacesMessage = null;
		
		
		
	/*	if() {
			myFacesMessage = new FacesMessage("Echec de la vérification", "The FAQ is incorrect");
			myFacesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			
		throw new ValidatorException(myFacesMessage);
		}
		
	}
	
	*/



}
