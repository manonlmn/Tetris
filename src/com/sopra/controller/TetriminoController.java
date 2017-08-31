package com.sopra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TetriminoController {

	@RequestMapping(value="/displaytetrimino", method=RequestMethod.GET)
	public String displayTetrimino() {
		return "displayTetrimino";
	}
	
	
	
}
