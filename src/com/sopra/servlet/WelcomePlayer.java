package com.sopra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomePlayer")
public class WelcomePlayer extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.getWriter().println("truc");
		this.getServletContext().getRequestDispatcher("/WEB-INF/welcomePlayer.jsp").forward(req, resp);
	}
	
	
}
