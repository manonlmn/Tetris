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


@WebServlet("/modifyBlock")
public class AddBlockFromModify extends ServletInChief {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IFigureDAO figDAO;

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
			//l'id de la figure que l'on modifie
				int id = Integer.parseInt(req.getParameter("id"));
				//création d'un block
				Block block = new Block();
				//donner les valeurs de X et Y au block
				block.setX(Integer.parseInt(req.getParameter("x")));
				block.setY(Integer.parseInt(req.getParameter("y")));
				
				List<Block> myBlocks = (List<Block>) req.getSession().getAttribute("ListBlock");

				boolean blockExist = false;
				//Pour chaque bloc de la liste de bloc
				for(Block bloc : myBlocks ) {
					//si le bloc existe déjà
					if(bloc.getX() == block.getX() && bloc.getY() == block.getY()) {
						//on le supprime de la liste
						myBlocks.remove(bloc);
						blockExist=true;
						break;
					}
				}
				if(blockExist==false) {
					//ajout à une liste de block
					myBlocks.add(block);
				}

				req.getSession().setAttribute("ListBlock", myBlocks);
				//on renvoie vers la servlet pour ajouter des figures
				response.sendRedirect("modifyFigure?id="+id);
	}

}
