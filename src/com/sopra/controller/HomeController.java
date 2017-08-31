package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IAdminDAO;
import com.sopra.model.Admin;

@Controller

public class HomeController {

	@Autowired
	private IAdminDAO adminDAO;


	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new Admin());
		return "home";
	}

	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String home(@ModelAttribute("user") Admin admin, Model model) {
		String myUserName = admin.getUsername();
		String myPwd = admin.getPassword();

		Admin adminSearched = adminDAO.searchbyUNandPWd(myUserName, myPwd);

		if(adminSearched!=null) {
			model.addAttribute("admin", adminSearched);
			return "redirect:/admin/"+adminSearched.getUsername();
		}
		else {
			return "home";
		}
	}
}
