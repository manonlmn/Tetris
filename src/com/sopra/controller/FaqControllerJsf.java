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


	boolean languageExist = false;
	boolean faqExist = false;



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
			this.faqExist = true;
		}
		else {
			myFAQ = myFAQDAO.add(myFAQ);
		}

		// Si la langue existe déjà (i.e. via une autre FAQ) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myLanguageDAO.searchByCode(this.languageCode) != null) {
			myLanguage = myLanguageDAO.searchByCode(this.languageCode);
			this.languageExist = true;
		}
		else {
			myLanguage.setCodeLanguage(languageCode);
			myLanguage = myLanguageDAO.add(myLanguage);
		}

		// Si la FAQLanguage n'existe pas encore, affectation des attributs et ajout dans la BDD
		if(!faqExist || !languageExist) {
			myFAQLanguage.setQuestionFAQLanguage(this.question);
			myFAQLanguage.setResponseFAQLanguage(this.response);
			myFAQLanguage.setMyLanguage(myLanguage);
			myFAQLanguage.setMyFAQ(myFAQ);
			this.myFAQLanguageDAO.add(myFAQLanguage);

			return "displayFAQ?faces-redirect=true";
		}
		else {
			return "addFAQ";
		}

	}



	// Supprimer FAQ
	public String deleteFAQLanguage(int idFAQ) {
		myFAQLanguageDAO.delete(myFAQLanguageDAO.search(idFAQ).getIdFAQLanguage());
		return "displayFAQ?faces-redirect=true";
	}



	// Modifier FAQ
	public String modifyFAQLanguage(int id) {
		// Récupération de l'entité FAQLanguage
		
		// Création des attributs
		FAQLanguage myFAQLanguage = myFAQLanguageDAO.search(id);
		Language myLanguage = new Language();
		FAQ myFAQ = new FAQ();

		// Si la FAQ existe déjà (i.e. dans un autre langage) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myFAQDAO.search(Integer.parseInt(this.refFAQ)) != null) {
			myFAQ = myFAQDAO.search(Integer.parseInt(this.refFAQ));
			this.faqExist = true;
		}
		else {
			myFAQ = myFAQDAO.add(myFAQ);
		}

		// Si la langue existe déjà (i.e. via une autre FAQ) on l'affecte, si ç'en est une nouvelle on la crée
		if(this.myLanguageDAO.searchByCode(this.languageCode) != null) {
			myLanguage = myLanguageDAO.searchByCode(this.languageCode);
			this.languageExist = true;
		}
		else {
			myLanguage.setCodeLanguage(languageCode);
			myLanguage = myLanguageDAO.add(myLanguage);
		}

		// Si la FAQLanguage n'existe pas encore, affectation des attributs et ajout dans la BDD
		if(!faqExist || !languageExist) {
			myFAQLanguage.setQuestionFAQLanguage(this.question);
			myFAQLanguage.setResponseFAQLanguage(this.response);
			myFAQLanguage.setMyLanguage(myLanguage);
			myFAQLanguage.setMyFAQ(myFAQ);
			this.myFAQLanguageDAO.modify(myFAQLanguage);

			return "displayFAQ?faces-redirect=true";
		}
		else {
			return "modifyFAQ?id="+id;
		}
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRefFAQ() {
		return refFAQ;
	}

	public void setRefFAQ(String refFAQ) {
		this.refFAQ = refFAQ;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}


}
