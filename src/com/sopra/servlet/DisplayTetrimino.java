package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.TetriminoDAO;

@WebServlet("/displaytetrimino")
public class DisplayTetrimino extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TetriminoDAO TetriDAO = (TetriminoDAO) req.getAttribute("myTetriminoDAO");
		List newList = TetriDAO.list();
		req.setAttribute("TetriminoList", newList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoDisplay.jsp").forward(req, resp);
		
	}

}