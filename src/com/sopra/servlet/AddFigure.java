package com.sopra.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlockDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Block;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

//@WebServlet("/AddFigure")
public class AddFigure extends ServletInChief {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITetriminoDAO tetriDAO;

	@Autowired
	private IBlockDAO blockDAO;

	@Autowired
	private IFigureDAO figDAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//r�cup�re id en param�tre
		int id=Integer.parseInt(request.getParameter("id"));

		//trouve le tetrimino via l'id
		Tetrimino myTetri = tetriDAO.search(id);

		//on le place en scope requete 
		request.setAttribute("Tetrimino", myTetri);
		
		List<Block> myBlocks = (List<Block>) request.getSession().getAttribute("ListBlock");

		//si la liste est vide/nulle, on l'initialise
		if ((myBlocks == null) || (!request.getHeader("referer").contains("AddFigure"))) {
			myBlocks = new ArrayList<Block>();
		}
		

		request.getSession().setAttribute("ListBlock", myBlocks);
		//on affiche la jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/FigureAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Block> blocks = (List<Block>) request.getSession().getAttribute("ListBlock");
		int id=Integer.parseInt(request.getParameter("id"));
		Tetrimino myTetri = tetriDAO.search(id);
		boolean error = false;

		Figure figure = new Figure();
		

		try {
			validationRotation(request.getParameter("numberRotation"));
			figure.setRotationNumber(Integer.parseInt(request.getParameter("numberRotation")));
		}catch(FormValidationException fve) {
			request.setAttribute("numberRotation", fve);        
			error = true;
		}
		try {
			RotationAlreadyExist(figure.getRotationNumber(), id);
		}catch(FormValidationException fve) {
			request.setAttribute("numberRotation", fve);        
			error = true;
		}
		
		figure.setTetrimino(myTetri);

		if(error == false) {
			figure = figDAO.add(figure);

			for(Block block : blocks) {
				block.setFigure(figure);
				block = blockDAO.add(block);
			}

			//on vide la liste de blocks
			blocks.clear();
			response.sendRedirect("displaytetrimino");
		}
		else {
			this.doGet(request, response);
		}
	}

	private void validationRotation(String parameter) throws FormValidationException {
		if(parameter.equals("")) {
			throw new FormValidationException("Please enter a number !");
		}
	}
	
	private void RotationAlreadyExist(int rotation, int idTetri) throws FormValidationException{
		Figure figure;
		figure = figDAO.searchByRotation(rotation, idTetri);
		if(figure != null) {
			throw new FormValidationException("Rotation already exists ! ");
		}
	}

}
