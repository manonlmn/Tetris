package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.TetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Tetrimino;

@WebServlet("/ModifyItem")
public class ModifyItem extends HttpServlet {

	//******************A MODIFIER EN MODIFY*******************
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Création d'un Tétrimino en récupérant les attributs de formulaire
		TetriminoDAO myTetriminoDAO = (TetriminoDAO)this.getServletContext().getAttribute("myTetriminoDAO");
		this.getServletContext().setAttribute("myTetriminoDAO", myTetriminoDAO);
		
		Tetrimino myTetriminoToSearch = new Tetrimino();
		int idToSearch = Integer.parseInt(request.getParameter("id"));
		myTetriminoToSearch = myTetriminoDAO.search(idToSearch);
		request.setAttribute("tetrimino", myTetriminoToSearch);
		
		// Renvoyer vers la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoModif.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Création d'un Tétrimino en récupérant les attributs de formulaire
		Tetrimino myNewTetrimino = new Tetrimino();
		boolean error = false;
		myNewTetrimino.setIdTetrimino(Integer.parseInt(request.getParameter("id")));
		myNewTetrimino.setNameTetrimino(request.getParameter("name"));
		try {
			validationNom(myNewTetrimino.getNameTetrimino());
		}catch(FormValidationException fve) {
			request.setAttribute("nameNewTetrimino", fve);		
			error = true;
			
		}
		myNewTetrimino.setColourTetrimino(request.getParameter("colour"));
		try {
			validationColour(myNewTetrimino.getColourTetrimino());
		}catch(FormValidationException fve) {
			request.setAttribute("colourNewTetrimino", fve);		
			error = true;
		}
		if(error==false) {
		// Envoi du tétrimino à la DAO
		TetriminoDAO myTetriminoDAO = (TetriminoDAO)this.getServletContext().getAttribute("myTetriminoDAO");
		myTetriminoDAO.modify(myNewTetrimino);
		
		this.getServletContext().setAttribute("myTetriminoDAO", myTetriminoDAO);
		
		response.sendRedirect("displaytetrimino");
		}
		else {
			doGet(request, response);
		}
	}
	
	private void validationNom(String nom) throws FormValidationException{
		if(nom.equals("")) {
			throw new FormValidationException("Please give a name to your tetrimino !");
		}
	}
	
	private void validationColour(String colour) throws FormValidationException{
		if(colour.equals("")) {
			throw new FormValidationException("Please enter a colour!");
		}
	}

}
