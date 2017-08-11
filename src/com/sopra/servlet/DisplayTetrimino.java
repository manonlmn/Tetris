package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displaytetrimino")
public class DisplayTetrimino extends HttpServlet {
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getAttribute("myTetriminoList");
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoDisplay.jsp").forward(req, resp);
		
	}

}