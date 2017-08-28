package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;

@WebServlet("/ListFiguresTetrimino")
public class ListFiguresTetrimino extends ServletInChief {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITetriminoDAO myTetriminoDAO;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tetrimino myTetrimino = myTetriminoDAO.search(Integer.parseInt(request.getParameter("id")));
		request.getSession().setAttribute("FiguresList", myTetrimino.getMyFigures());
		request.getSession().setAttribute("Tetrimino", myTetrimino);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/FiguresDisplay.jsp").forward(request, response);
	}
}
