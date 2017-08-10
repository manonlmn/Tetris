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

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String myUserName = req.getParameter("username");
		String myPwd = req.getParameter("password");
		
		if(myUserName.equals("admin") && myPwd.equals("admin")) {
			req.getSession().setAttribute("username", myUserName);
			req.getSession().setAttribute("password", myPwd);
		}

		this.doGet(req, resp);
	}


}
