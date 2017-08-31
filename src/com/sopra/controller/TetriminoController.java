package com.sopra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;
import com.sopra.validator.AddTetriminoValidator;

@Controller
public class TetriminoController {
	
	@Autowired
	private ITetriminoDAO myTetriminoDAO;
	
	@Autowired
	private IFigureDAO myFigureDAO;

	
	
	@RequestMapping(value="/displaytetrimino", method=RequestMethod.GET)
	public String displayTetrimino(	Model model
									) {
		
		model.addAttribute("TetriminoList", myTetriminoDAO.list());
		return "displayTetrimino";
	}
	
	// Afficher la page d'ajout de Tetrimino
	@RequestMapping(value="/addTetrimino", method=RequestMethod.GET)
	public String addTetrimino(	Model model
								) {
		model.addAttribute("newTetrimino", new Tetrimino());
		return "addTetrimino";
	}
	
	// Faire la manip d'ajout
	@RequestMapping(value="/doAddTetrimino", method=RequestMethod.POST)
	public String addTetrimino(	@Valid @ModelAttribute("newTetrimino") Tetrimino myNewTetrimino,
								BindingResult result,
								Model model
								) {

		new AddTetriminoValidator().validate(myNewTetrimino, result);
		
		if(result.hasErrors()) {
			return "addTetrimino";
			}
		
		myTetriminoDAO.add(myNewTetrimino);
		return "redirect:/displaytetrimino";
	}
	
	// Supprimer Tetrimino
	@RequestMapping(value="/DeleteTetrimino", method=RequestMethod.GET)
	public String deleteTetrimino(	@RequestParam(value="id") int idTetriminoToDelete
									) {
		myTetriminoDAO.delete(idTetriminoToDelete);
		
		return "redirect:/displaytetrimino";
	}
	
	
	
	// Modification tetrimino
	// Afficher la page de manipulation des figures
	@RequestMapping(value="/ListFiguresTetrimino", method=RequestMethod.GET)
	public String displayFigure(@RequestParam(value="id") int idTetriminoFigures,
								Model model
								) {
		
		Tetrimino myTetrimino = myTetriminoDAO.search(idTetriminoFigures);
		model.addAttribute("Tetrimino", myTetrimino);
		
		return "displayFigure";
	}
	
	// Afficher la page d'ajout de figure
	@RequestMapping(value="/AddFigure", method=RequestMethod.GET)
	public String addFigure(@RequestParam(value="id") int idTetriminoFigures,
							Model model
							) {
		model.addAttribute("Tetrimino", myTetriminoDAO.search(idTetriminoFigures));
		
		return "addFigure";
	}
	
	
	// Faire la manip d'ajouter une figure
	
	
}
