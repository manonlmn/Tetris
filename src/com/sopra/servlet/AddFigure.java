package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.ITetriminoDAO;
import com.sopra.model.Tetrimino;

@WebServlet("/AddFigure")
public class AddFigure extends ServletInChief {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private ITetriminoDAO tetriDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Tetrimino myTetri = tetriDAO.search(id);
		request.setAttribute("Tetrimino", myTetri);
		this.getServletContext().getRequestDispatcher("/WEB-INF/FigureAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
