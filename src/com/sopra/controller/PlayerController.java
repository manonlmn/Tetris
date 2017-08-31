package com.sopra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Player;

@Controller
public class PlayerController {
	
	@Autowired
	private IPlayerDAO myPlayerDAO;
	
	@RequestMapping(value="/displayplayer", method=RequestMethod.GET)
	public String displayPlayer(	Model model
									) {
		
		model.addAttribute("PlayersList", myPlayerDAO.list());						
		return "displayPlayer";
	}
	
	@RequestMapping(value="/BanPlayer", method=RequestMethod.GET)
	public String banPlayer(	@RequestParam(value="id") int idPlayer
								) {
		
		Player myPlayerToBan;
		myPlayerToBan = myPlayerDAO.search(idPlayer);
		myPlayerToBan.modifyBanned();
		myPlayerDAO.modify(myPlayerToBan);
		
		return "redirect:/displayplayer";
	}
	
}
