package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.IPlayerDAO;

@WebServlet("/displayplayer")
public class DisplayPlayer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB 
	private IPlayerDAO playerDAO;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("PlayersList", playerDAO.list());
		this.getServletContext().getRequestDispatcher("/WEB-INF/GamerDisplay.jsp").forward(req, resp);
	}

}
