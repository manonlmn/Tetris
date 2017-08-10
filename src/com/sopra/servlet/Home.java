package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		if(req.getSession().getAttribute("username")==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(req, resp);	
		}
		else {
			resp.sendRedirect("/Tetris/welcome");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String myUserName = req.getParameter("username");
		String myPwd = req.getParameter("password");

		if(myUserName.equals("admin") && myPwd.equals("admin")) {
			resp.sendRedirect("/tp1/welcome");
		}

		this.doGet(req, resp);
	}

}
