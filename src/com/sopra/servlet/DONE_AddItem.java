package com.sopra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.exception.FormValidationException;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;

//@WebServlet("/newitem")
public class DONE_AddItem extends ServletInChief {
	//num�ro de s�rie pour �viter les warnings
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITetriminoDAO TetriDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Renvoyer vers la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoAdd.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean error = false;

		// Création d'un Tétrimino en récupérant les attributs de formulaire
		Tetrimino myNewTetrimino = new Tetrimino();


		myNewTetrimino.setNameTetrimino(request.getParameter("nameNewTetrimino"));
		try {
			validationNom(myNewTetrimino.getNameTetrimino());
		}catch(FormValidationException fve) {
			request.setAttribute("nameNewTetrimino", fve);		
			error =true;
		}

		try {
			validationCoef(request.getParameter("coefNewTetrimino"));
			myNewTetrimino.setCoef(Integer.parseInt(request.getParameter("coefNewTetrimino")));
		}catch(FormValidationException fve) {
			request.setAttribute("coefNewTetrimino", fve);		
			error =true;
		}

		myNewTetrimino.setColourTetrimino(request.getParameter("colourNewTetrimino"));
		try {
			validationColour(myNewTetrimino.getColourTetrimino());
		}catch(FormValidationException fve) {
			request.setAttribute("colourNewTetrimino", fve);		
			error =true;
		}

		if(error==false) {

			Tetrimino newTetri;
			newTetri= TetriDAO.add(myNewTetrimino);
			//request.setAttribute("TetriminoList", TetriDAO.list());
			response.sendRedirect("displaytetrimino");
		}
		else {
			//response.sendRedirect("newitem");
			this.doGet(request, response);
		}

	}

	private void validationNom(String nom) throws FormValidationException{
		if(nom.equals("")) {
			throw new FormValidationException("Please give a name to your tetrimino !");
		}
	}

	private void validationCoef(String coef) throws FormValidationException{
		if(coef.equals("")) {
			throw new FormValidationException("Please give a coef to your tetrimino !");
		}
	}

	private void validationColour(String colour) throws FormValidationException{
		if(colour.equals("")) {
			throw new FormValidationException("Please enter a colour!");
		}
	}
}
