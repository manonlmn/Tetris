package com.sopra.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

//@WebServlet("/welcome")
public class AdminWelcome extends ServletInChief {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().getAttribute("username"); 

		this.getServletContext().getRequestDispatcher("/WEB-INF/Choice.jsp").forward(req, resp);


	}


}
