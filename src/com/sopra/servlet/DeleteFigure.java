package com.sopra.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IFigureDAO;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@WebServlet("/deleteFigure")
public class DeleteFigure extends ServletInChief {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IFigureDAO myFigureDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idFigureToDelete = Integer.parseInt(request.getParameter("id"));
		Figure figure = myFigureDAO.search(idFigureToDelete);
		
		myFigureDAO.delete(idFigureToDelete);
		response.sendRedirect("ListFiguresTetrimino?id="+figure.getTetrimino().getIdTetrimino());
	}
}
