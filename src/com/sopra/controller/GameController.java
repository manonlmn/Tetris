package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sopra.dao.IGameDAO;

@Controller
public class GameController {

	@Autowired
	private IGameDAO myGameDAO;
	
	@RequestMapping(value="/displayGamesList", method = RequestMethod.GET)
	public String listGame(	Model model
							) {
		
		model.addAttribute("GamesList", myGameDAO.list());
		return "displayGamesList";
	}
}
