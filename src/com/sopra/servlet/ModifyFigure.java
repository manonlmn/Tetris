package com.sopra.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IBlockDAO;
import com.sopra.dao.IFigureDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Block;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@WebServlet("/modifyFigure")
public class ModifyFigure extends ServletInChief {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IFigureDAO figDAO;

	@Autowired
	private ITetriminoDAO tetriDAO;

	@Autowired
	private IBlockDAO blockDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Figure figure;
		figure = figDAO.search(id);

		Tetrimino tetri;
		tetri = figure.getTetrimino();

		
		
		
		List<Block> myBlocks = (List<Block>) req.getSession().getAttribute("ListBlock");

		//si la liste est vide/nulle, on l'initialise
		if ((myBlocks == null) || (!req.getHeader("referer").contains("modifyFigure"))) {
			myBlocks = figure.getMyBlocks();
		}
		

		req.getSession().setAttribute("Tetrimino", tetri);
		req.getSession().setAttribute("figure", figure);
		req.getSession().setAttribute("ListBlock", myBlocks);


		//on affiche la jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/ModifyFigure.jsp").forward(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Block> blocks = (List<Block>) request.getSession().getAttribute("ListBlock");
		int id=Integer.parseInt(request.getParameter("id"));

		//on cherche la figure à modifier
		Figure figure = figDAO.search(id);

		for(Block block : figure.getMyBlocks()) {
			blockDAO.delete(block.getIdBlock());
		}
		
		
		for(Block block : blocks) {
			block.setFigure(figure);
			block = blockDAO.modify(block);
		}
		
		request.getSession().removeAttribute("ListBlock");
		response.sendRedirect("ListFiguresTetrimino?id="+figure.getTetrimino().getIdTetrimino());
	}


}
