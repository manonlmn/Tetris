package com.sopra.servlet;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IAdminDAO;
import com.sopra.model.Admin;


public class Home extends ServletInChief {

	private static final long serialVersionUID = 1L;

	@Autowired
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
