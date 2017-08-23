package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Player;

@WebServlet("/WelcomePlayer")
public class WelcomePlayer extends HttpServlet {
	@EJB
	private IPlayerDAO playDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idPlayer = Integer.parseInt(req.getParameter("id"));
		Player player = new Player();
		player = playDAO.search(idPlayer);
		req.setAttribute("player", player);
		this.getServletContext().getRequestDispatcher("/WEB-INF/welcomePlayer.jsp").forward(req, resp);
	}
	
	
}
