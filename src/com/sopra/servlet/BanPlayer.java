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

/**
 * Servlet implementation class BanPlayer
 */
@WebServlet("/BanPlayer")
public class BanPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IPlayerDAO playerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player myPlayerToBan;
		
		myPlayerToBan=playerDAO.search(Integer.parseInt(request.getParameter("id")));
		myPlayerToBan.modifyBanned();
		myPlayerToBan = playerDAO.modify(myPlayerToBan);
		
		response.sendRedirect("displayplayer");
	}

}
