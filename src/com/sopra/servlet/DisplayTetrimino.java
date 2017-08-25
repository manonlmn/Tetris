package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

@WebServlet("/displaytetrimino")
public class DisplayTetrimino extends ServletInChief {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITetriminoDAO TetriDAO;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("TetriminoList", TetriDAO.list());
		this.getServletContext().getRequestDispatcher("/WEB-INF/TetriminoDisplay.jsp").forward(req, resp);
		
	}

}