package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.TetriminoDAO;
import com.sopra.model.Tetrimino;

@WebServlet("/ModifyItem")
public class ModifyItem extends HttpServlet {

	//******************A MODIFIER EN MODIFY*******************
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Renvoyer vers la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoModif.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Création d'un Tétrimino en récupérant les attributs de formulaire
				Tetrimino myNewTetrimino = new Tetrimino();
				myNewTetrimino.setNameTetrimino(request.getParameter("nameNewTetrimino"));
				myNewTetrimino.setColourTetrimino(request.getParameter("colourNewTetrimino"));
				
				// Envoi du tétrimino à la DAO
				TetriminoDAO myTetriminoDAO = (TetriminoDAO)this.getServletContext().getAttribute("myTetriminoDAO");
				myTetriminoDAO.add(myNewTetrimino);
				
				this.getServletContext().setAttribute("myTetriminoDAO", myTetriminoDAO);
				
				response.sendRedirect("displaytetrimino");
	}

}
