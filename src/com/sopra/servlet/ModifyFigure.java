package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IFigureDAO;
import com.sopra.model.Block;
import com.sopra.model.Figure;

@WebServlet("/modifyFigure")
public class ModifyFigure extends ServletInChief {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IFigureDAO figDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Figure figure;
		figure = figDAO.search(id);
		
		List<Block> myBlocks = figure.getMyBlocks();
		
		
		
	}
	
	
	

}
