package com.sopra.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.IAdminDAO;
import com.sopra.dao.IPlayerDAO;
import com.sopra.model.Admin;

@WebServlet("/home")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private IAdminDAO adminDAO;



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

		Admin admin = adminDAO.searchbyUNandPWd(myUserName, myPwd);

		if(admin!=null) {
			req.getSession().setAttribute("username", myUserName);
			req.getSession().setAttribute("password", myPwd);

		}

		this.doGet(req, resp);
	}


}
