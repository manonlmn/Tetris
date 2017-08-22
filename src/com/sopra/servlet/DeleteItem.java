package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.dao.TetriminoDAO;
import com.sopra.dao.hibernate.TetriminoDaoHibernate;
import com.sopra.model.Tetrimino;

@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	@EJB
	private ITetriminoDAO TetriDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idToSearch = Integer.parseInt(request.getParameter("id"));
		TetriDAO.delete(idToSearch);
		response.sendRedirect("displaytetrimino");
	}
	
}
