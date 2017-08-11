package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.TetriminoDAO;
import com.sopra.model.Tetrimino;

@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Création d'un Tétrimino en récupérant les attributs de formulaire
		TetriminoDAO myTetriminoDAO = (TetriminoDAO)this.getServletContext().getAttribute("myTetriminoDAO");
		this.getServletContext().setAttribute("myTetriminoDAO", myTetriminoDAO);
		
		Tetrimino myTetriminoToSearch = new Tetrimino();
		myTetriminoToSearch = myTetriminoDAO.search(Integer.parseInt(request.getParameter("id")));

		myTetriminoDAO.delete(myTetriminoToSearch);
		response.sendRedirect("displaytetrimino");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
