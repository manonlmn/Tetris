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
import com.sopra.model.Block;

@WebServlet("/AddBlock")
public class AddBlock extends ServletInChief {

	private static final long serialVersionUID = 1L;

	@Autowired 
	private IBlockDAO blockDAO;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//l'id du tetrimino auquel on rajoute les formes 
		int id = Integer.parseInt(req.getParameter("id"));
		//création d'un block
		Block block = new Block();
		//set le block 
		block.setX(Integer.parseInt(req.getParameter("x")));
		block.setY(Integer.parseInt(req.getParameter("y")));

		//ajout à la bdd
		block = blockDAO.add(block);
		
		List<Block> myBlocks = (List<Block>) req.getSession().getAttribute("ListBlock");
		
		if (myBlocks == null) {
			myBlocks = new ArrayList<Block>();
		}
				
				
		//ajout à une liste de block
		myBlocks.add(block);
		
		//on met la liste de block en session
		req.getSession().setAttribute("ListBlock", myBlocks);
		
		resp.sendRedirect("AddFigure?id="+id);
	}
	
	

}
