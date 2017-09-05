package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.dao.TetriminoDAO;
import com.sopra.dao.hibernate.TetriminoDaoHibernate;
import com.sopra.model.Tetrimino;

//@WebServlet("/DeleteItem")
public class DONE_DeleteItem extends ServletInChief {
	
	@Autowired
	private ITetriminoDAO TetriDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idToSearch = Integer.parseInt(request.getParameter("id"));
		TetriDAO.delete(idToSearch);
		response.sendRedirect("displaytetrimino");
	}
	
}
