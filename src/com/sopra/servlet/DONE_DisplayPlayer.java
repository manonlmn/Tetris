package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IPlayerDAO;

//@WebServlet("/displayplayer")
public class DONE_DisplayPlayer extends ServletInChief {

	@Autowired
	private IPlayerDAO playerDAO;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("PlayersList", playerDAO.list());
		this.getServletContext().getRequestDispatcher("/WEB-INF/GamerDisplay.jsp").forward(req, resp);
	}

}
