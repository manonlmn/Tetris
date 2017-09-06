package com.sopra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sopra.dao.IFAQDAO;
import com.sopra.dao.IFAQLanguageDAO;
import com.sopra.dao.ILanguageDAO;
import com.sopra.model.FAQ;
import com.sopra.model.FAQLanguage;
import com.sopra.model.Language;

@Controller
@Scope("request")
public class FaqControllerJsf {

	private String question = "";
	private String response = "";
	private String refFAQ = "";
	private String languageCode = null;
	@Autowired private IFAQLanguageDAO myFAQLanguageDAO;
	@Autowired private ILanguageDAO myLanguageDAO;
	@Autowired private IFAQDAO myFAQDAO;



	// Lister FAQ
	public List<FAQ> listFAQ() {
		List<FAQ> myListFAQ = this.myFAQDAO.list();
		return myListFAQ;
	}



	// Lister FAQLanguage
	public List<FAQLanguage> listFAQLanguage() {
		System.out.println("pass� par l�");
		List<FAQLanguage> myListFAQLanguage = this.myFAQLanguageDAO.list();
		return myListFAQLanguage;
	}



	// Ajouter FAQLanguage
	public String addFAQLanguage() {

		// Création de l'entité FAQLanguage
		FAQLanguage myFAQLanguage = new FAQLanguage();
		Language myLanguage = new Language();
		FAQ myFAQ = new FAQ();

		// Si la FAQ existe déjà (i.e. dans un autre langage) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myFAQDAO.search(Integer.parseInt(this.refFAQ)) != null) {
			myFAQ = myFAQDAO.search(Integer.parseInt(this.refFAQ));
		}
		else {
			myFAQ = myFAQDAO.add(myFAQ);
		}

		// Si la langue existe déjà (i.e. via une autre FAQ) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myLanguageDAO.searchByCode(this.languageCode) != null) {
			myLanguage = myLanguageDAO.searchByCode(this.languageCode);
		}
		else {
			myLanguage.setCodeLanguage(languageCode);
			myLanguageDAO.add(myLanguage);
		}

		// Affectation des attributs de FAQLanguage et ajout dans la BDD
		myFAQLanguage.setQuestionFAQLanguage(this.question);
		myFAQLanguage.setResponseFAQLanguage(this.response);
		myFAQLanguage.setMyLanguage(myLanguage);
		myFAQLanguage.setMyFAQ(myFAQ);
		this.myFAQLanguageDAO.add(myFAQLanguage);

		return "displayFAQ?faces-redirect=true";
	}



	// Supprimer FAQ
	public String deleteFAQ(int idFAQ) {
		myFAQLanguageDAO.delete(myFAQLanguageDAO.search(idFAQ).getIdFAQLanguage());
		return "displayFAQ?faces-redirect=true";
	}



	// Modifier FAQ
	public String modifyFAQ(int id) {

		// Récupération de l'entité FAQLanguage
		FAQLanguage myFAQLanguage = this.myFAQLanguageDAO.search(id);
		
		// Création des nouveaux objets attributs
		Language myLanguage = new Language();
		FAQ myFAQ = new FAQ();

		// Si la FAQ existe déjà (i.e. dans un autre langage) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myFAQDAO.search(Integer.parseInt(this.refFAQ)) != null) {
			myFAQ = myFAQDAO.search(Integer.parseInt(this.refFAQ));
		}
		else {
			myFAQ = myFAQDAO.add(myFAQ);
		}

		// Si la langue existe déjà (i.e. via une autre FAQ) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myLanguageDAO.searchByCode(this.languageCode) != null) {
			myLanguage = myLanguageDAO.searchByCode(this.languageCode);
		}
		else {
			myLanguage.setCodeLanguage(languageCode);
			myLanguageDAO.add(myLanguage);
		}

		// Affectation des attributs de FAQLanguage et modification dans la BDD
		myFAQLanguage.setQuestionFAQLanguage(this.question);
		myFAQLanguage.setResponseFAQLanguage(this.response);
		myFAQLanguage.setMyLanguage(myLanguage);
		myFAQLanguage.setMyFAQ(myFAQ);
		this.myFAQLanguageDAO.modify(myFAQLanguage);

		return "displayFAQ?faces-redirect=true";
	}
}
