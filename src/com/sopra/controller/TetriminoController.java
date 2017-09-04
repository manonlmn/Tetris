package com.sopra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.dao.IBlockDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Block;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;
import com.sopra.validator.AddFigureValidator;
import com.sopra.validator.AddTetriminoValidator;

@Controller
public class TetriminoController {

	@Autowired
	private ITetriminoDAO myTetriminoDAO;

	@Autowired
	private IFigureDAO myFigureDAO;

	@Autowired
	private IBlockDAO myBlockDAO;



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



	//afichage du tetri ï¿½ modifier
	@RequestMapping(value="/ModifyTetrimino", method=RequestMethod.GET)
	public String modifyTetrimino(@RequestParam(value="id") int idTetriminoToModify, Model model) {
		Tetrimino tetriToModify = myTetriminoDAO.search(idTetriminoToModify);
		model.addAttribute("tetritoModify", tetriToModify);
		return "modifyTetrimino";
	}

	//modif du tetri
	@RequestMapping(value="/doModifyTetri", method=RequestMethod.POST)
	public String modifyTetrimino(	@Valid @ModelAttribute("tetritoModify") Tetrimino tetriToModify,
			BindingResult result,
			Model model
			) {
		new AddTetriminoValidator().validate(tetriToModify, result);
		if(result.hasErrors()) {
			return "modifyTetrimino";
		}

		myTetriminoDAO.modify(tetriToModify);
		return "redirect:/displaytetrimino";
	}

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
			HttpSession session,
			@RequestHeader(value="Referer", required=false) String referer,
			Model model
			) {

		Tetrimino myTetrimino = myTetriminoDAO.search(idTetriminoFigures);

		model.addAttribute("Tetrimino", myTetrimino);
		model.addAttribute("mySession", session);
		model.addAttribute("newFigure", new Figure());

		List<Block> myListBlocks = (List<Block>)session.getAttribute("ListBlock");

		if ((myListBlocks == null) || referer == null || !referer.contains("AddFigure")) {
			myListBlocks = new ArrayList<Block>();
		}

		session.setAttribute("ListBlock", myListBlocks);
		return "addFigure";
	}


	// Faire la manip d'ajouter une figure
	@RequestMapping(value="/doAddFigure", method=RequestMethod.POST)
	public String addFigure(@Valid @ModelAttribute("newFigure") Figure myNewFigure,
			BindingResult result,
			@RequestParam(value="id") int idTetrimino,
			HttpSession session,
			Model model
			) {

		Tetrimino myTetrimino = myTetriminoDAO.search(idTetrimino);
		List<Figure> myListFigure = myTetrimino.getMyFigures();
		List<Block> myListBlocks = (List<Block>)session.getAttribute("ListBlock");

		new AddFigureValidator().validate(myNewFigure, myListFigure, result);

		if(result.hasErrors()) {
			//return this.addFigure(idTetrimino, session, "AddFigure", model);
			model.addAttribute("Tetrimino", myTetrimino);
			model.addAttribute("mySession", session);
			//model.addAttribute("newFigure", new Figure());
			
			return "addFigure";
		}

		myNewFigure.setTetrimino(myTetrimino);
		myNewFigure = myFigureDAO.add(myNewFigure);
		for(Block block : myListBlocks) {
			block.setFigure(myNewFigure);
			myBlockDAO.add(block);
		}

		myListBlocks.clear();

		return "redirect:/ListFiguresTetrimino?id="+idTetrimino;
	}



	// Supprimer une figure
	@RequestMapping(value="/deleteFigure", method=RequestMethod.GET)
	public String deleteFigure(	@RequestParam(value="id") int idFigureToDelete
			) {
		Figure myFigure = myFigureDAO.search(idFigureToDelete);
		myFigureDAO.delete(idFigureToDelete);

		return "redirect:/ListFiguresTetrimino?id="+ myFigure.getTetrimino().getIdTetrimino();
	}


	// Afficher la page de modification d'une figure
	@RequestMapping(value="/modifyFigure", method=RequestMethod.GET)
	public String modifyFigure(	@RequestParam(value="id") int idFigure,
			HttpSession session,
			@RequestHeader(value="Referer", required=false) String referer,
			Model model
			) {

		Figure myFigureToModify = myFigureDAO.search(idFigure);
		Tetrimino myTetrimino = myFigureToModify.getTetrimino();
		List<Block> myListBlock = (List<Block>)session.getAttribute("ListBlock");

		if ((myListBlock == null) || referer == null || !referer.contains("modifyFigure")) {
			myListBlock = myFigureToModify.getMyBlocks();
			session.setAttribute("ListBlock", myListBlock);
		}

		model.addAttribute("Tetrimino", myTetrimino);
		model.addAttribute("figure", myFigureToModify);
		//model.addAttribute("ListBlock", myListBlock);

		return "modifyFigure";
	}


	// Faire la modification d'une figure
	@RequestMapping(value="/doModifyFigure", method=RequestMethod.POST)
	public String modifyFigure(	@RequestParam(value="id") int idFigure,
			HttpSession session
			) {

		List<Block> myListBlock = (List<Block>)session.getAttribute("ListBlock");
		Figure myFigure = myFigureDAO.search(idFigure);

		for(Block myBlock : myFigure.getMyBlocks()) {
			myBlockDAO.delete(myBlock.getIdBlock());
		}

		for(Block myBlock : myListBlock) {
			myBlock.setFigure(myFigure);
			myBlock = myBlockDAO.modify(myBlock);
		}

		session.removeAttribute("ListBlock");

		return "redirect:/ListFiguresTetrimino?id="+myFigure.getTetrimino().getIdTetrimino();
	}



	// Ajouter un bloc
	@RequestMapping(value="/AddBlock", method=RequestMethod.GET)
	public String addBlock(	@RequestParam(value="id") int idTetrimino,
			@RequestParam(value="x") int xBlock,
			@RequestParam(value="y") int yBlock,
			HttpSession session,
			Model model
			) {

		List<Block> myListBlock = (List<Block>)session.getAttribute("ListBlock");

		boolean blockExist = false;

		for(Block myBlock : myListBlock) {
			if(myBlock.getX() == xBlock && myBlock.getY() == yBlock) {
				myListBlock.remove(myBlock);
				blockExist=true;
				break;
			}
		}

		if(!blockExist) {
			Block myBlockToAdd = new Block();

			myBlockToAdd.setX(xBlock);
			myBlockToAdd.setY(yBlock);

			myListBlock.add(myBlockToAdd);
		}

		session.setAttribute("ListBlock", myListBlock);

		return "redirect:/AddFigure?id="+idTetrimino;
	}



	// Modifier un bloc
	@RequestMapping(value="/modifyBlock", method=RequestMethod.GET)
	public String modifyBlock(	HttpSession session,
			@RequestParam(value="id") int idFigure,
			@RequestParam(value="x") int xBlock,
			@RequestParam(value="y") int yBlock
			) {

		Figure myFigure = myFigureDAO.search(idFigure);
		Tetrimino myTetrimino = myFigure.getTetrimino();
		List<Block> myListBlock = (List<Block>)session.getAttribute("ListBlock");

		boolean blockExist = false;

		for(Block myBlock : myListBlock ) {
			if(myBlock.getX() == xBlock && myBlock.getY() == yBlock) {
				myListBlock.remove(myBlock);
				blockExist=true;
				break;
			}
		}
		if(!blockExist) {
			Block myBlockToModify = new Block();
			myBlockToModify.setX(xBlock);
			myBlockToModify.setY(yBlock);
			myListBlock.add(myBlockToModify);

		}

		session.setAttribute("ListBlock", myListBlock);

		return "redirect:/modifyFigure?id="+idFigure;
	}
	
	//switch de figure 
	
	@RequestMapping(value="/switchFigureRight", method = RequestMethod.GET)
	public String switchFigures(@RequestParam int id, @RequestParam int sens, Model model ) {
		Figure figure = myFigureDAO.search(id);
		Tetrimino tetrimino = figure.getTetrimino();
		
		int newOrder;
		
		newOrder = figure.getRotationNumber()+1;
		
		//verfier que l'ordre n'existe pas dans la liste
		
		//si ordre existant, inversion avec l'ancien ordre
		
		//on sauvegarde grâce à la dao dans la bdd
		
		
		return "displayFigure";
	}
	
	//meme chose mais sens inverse


}
