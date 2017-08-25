package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IGameDAO;

@WebServlet("/displayGamesList")
public class DisplayGamesList extends ServletInChief {
	
	@Autowired
	private IGameDAO gameDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("GamesList", gameDAO.listWithScore());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/GamesListDisplay.jsp").forward(request, response);
	}

}
