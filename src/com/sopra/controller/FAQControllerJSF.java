package com.sopra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IFAQDAO;
import com.sopra.dao.IFAQLanguageDAO;
import com.sopra.dao.ILanguageDAO;
import com.sopra.model.FAQ;
import com.sopra.model.FAQLanguage;
import com.sopra.model.Language;
import com.sopra.validator.AddFAQValidatorJSF;

@Controller
@Scope("request")
public class FAQControllerJSF {
	
	private String question = "";
	private String response = "";
	private String languageCode = null;
	@Autowired private IFAQLanguageDAO myFAQLanguageDAO;
	@Autowired private ILanguageDAO myLanguageDAO;
	
	// Lister FAQ
	public List<FAQLanguage> listFAQLanguage() {
		List<FAQLanguage> myListFAQLanguage = this.myFAQLanguageDAO.list();
		return myListFAQLanguage;
	}
	
	// Ajouter FAQ
	public String addFAQLanguage() {
		
		// Création de l'entité FAQ
		FAQLanguage myFAQLanguage = new FAQLanguage();
		Language myLanguage = myLanguageDAO.searchByCode(languageCode);
		
		myFAQLanguage.setMyLanguage(myLanguage);
		myFAQLanguage.setQuestionFAQLanguage(question);
		myFAQLanguage.setResponseFAQLanguage(response);
		myFAQLanguage.setMyFAQ(   /* La FAQ */  );
		this.myFAQLanguageDAO.add(myFAQLanguage);
		
		return "displayFAQ?faces-redirect=true";
	}
	
	// Supprimer FAQ
	public String deleteFAQ(int idFAQ) {
		myFAQLanguageDAO.delete(myFAQLanguageDAO.search(idFAQ).getIdFAQLanguage());
		return "displayFAQ?faces-redirect=true";
	}
	
	// Modifier FAQ
	public String modifyFAQ(FAQLanguage myFAQ) {
		myFAQLanguageDAO.modify(myFAQ);
		return "displayFAQ?faces-redirect=true";
	}
}
