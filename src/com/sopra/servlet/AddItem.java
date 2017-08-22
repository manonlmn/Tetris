package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sopra.exception.FormValidationException;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.dao.TetriminoDAO;
import com.sopra.dao.hibernate.TetriminoDaoHibernate;
import com.sopra.model.Tetrimino;

@WebServlet("/newitem")
public class AddItem extends HttpServlet {
	@EJB
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
		myNewTetrimino.setColourTetrimino(request.getParameter("colourNewTetrimino"));
		try {
			validationColour(myNewTetrimino.getColourTetrimino());
		}catch(FormValidationException fve) {
			request.setAttribute("colourNewTetrimino", fve);		
			error =true;
		}
		
		
		if(error==false) {
		
			Tetrimino newTetri = new Tetrimino();
			newTetri = TetriDAO.add(myNewTetrimino);
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
	
	private void validationColour(String colour) throws FormValidationException{
		if(colour.equals("")) {
			throw new FormValidationException("Please enter a colour!");
		}
	}
}
