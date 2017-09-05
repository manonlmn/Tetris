package com.sopra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IFAQDAO;
import com.sopra.model.FAQ;
import com.sopra.validator.AddFAQValidator;

@Controller
public class FAQController {
	
	@Autowired
	private IFAQDAO myFAQDAO;

	// Afficher la FAQ
	
	public String displayFAQ() {
		//creation d'une fonction pour lister les FAQ
		return "displayFAQ";
	}
	
	
	// Afficher la page d'ajout de FAQ
	@RequestMapping(value="/addFaq", method=RequestMethod.GET)
	public String addFAQ(Model model) {
		model.addAttribute("myNewFAQ");
		return "addFAQ";
	}
	
	
	// Ajouter une FAQ
	@RequestMapping(value="/doAddFaq", method=RequestMethod.POST)
	public String addFAQ(	@Valid @ModelAttribute("myNewFAQ") FAQ myNewFAQ,
							BindingResult result,
							Model model
							) {
		
		new AddFAQValidator().validate(myNewFAQ, result);
		if(result.hasErrors()) {
			return "addFAQ";
		}
		myNewFAQ = this.myFAQDAO.add(myNewFAQ);
		return "redirect:/faq";
	}
	
	
	// Supprimer une FAQ
	@RequestMapping(value="/deleteFAQ", method=RequestMethod.GET)
	public String deleteFAQ(	@RequestParam(value="id") int idFAQ
			) {
		myFAQDAO.delete(idFAQ);

		return "redirect:/faq";
	}
	
	
	// Afficher la page de modification de FAQ
	@RequestMapping(value="/modifyFAQ", method=RequestMethod.GET)
	public String modifyFAQ(@RequestParam(value="id") int idFAQToModify, Model model) {
		FAQ FAQToModify = myFAQDAO.search(idFAQToModify);
		model.addAttribute("FAQToModify", FAQToModify);
		return "modifyFAQ";
	}
	
	
	// Modifier une FAQ
	@RequestMapping(value="/doModifyFAQ", method=RequestMethod.POST)
	public String modifyFAQ(@Valid @ModelAttribute("FAQToModify") FAQ FAQToModify,
							BindingResult result,
							Model model
							) {
		new AddFAQValidator().validate(FAQToModify, result);
		if(result.hasErrors()) {
			return "modifyFAQ";
		}

		myFAQDAO.modify(FAQToModify);
		return "redirect:/faq";
	}
	
	
	
	
}
