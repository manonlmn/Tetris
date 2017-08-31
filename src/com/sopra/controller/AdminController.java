package com.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AdminController {
	
	@RequestMapping(value="/admin/{username}", method = RequestMethod.GET)
	public String admin(@PathVariable String username, Model model) {
		model.addAttribute("username", username);
		return "displayAdmin";
	}
}
