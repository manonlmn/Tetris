package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Player;

/**
 * Servlet implementation class BanPlayer
 */
@WebServlet("/BanPlayer")
public class BanPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPlayerDAO playerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/GamerDisplay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player myPlayerToBan = new Player();
		Player player = new Player();
		myPlayerToBan.setIdPerson(Integer.parseInt(request.getParameter("id")));
		myPlayerToBan.setBanned(true);
		player = playerDAO.modify(myPlayerToBan);
		doGet(request, response);
	}

}
