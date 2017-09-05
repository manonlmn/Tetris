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
import com.sopra.model.Block;

//@WebServlet("/AddBlock")
public class DONE_AddBlock extends ServletInChief {
	//num�ro de s�rie
	private static final long serialVersionUID = 1L;
	//ajout de la DAO pour les blocks 
	@Autowired 
	private IBlockDAO blockDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//l'id du tetrimino auquel on rajoute les formes 
		int id = Integer.parseInt(req.getParameter("id"));
		//cr�ation d'un block
		Block block = new Block();
		//donner les valeurs de X et Y au block
		block.setX(Integer.parseInt(req.getParameter("x")));
		block.setY(Integer.parseInt(req.getParameter("y")));

		List<Block> myBlocks = (List<Block>) req.getSession().getAttribute("ListBlock");
		
		boolean blockExist = false;
		//Pour chaque bloc de la liste de bloc
		for(Block bloc : myBlocks) {
			//si le bloc existe d�j�
			if(bloc.getX() == block.getX() && bloc.getY() == block.getY()) {
				//on le supprime de la liste via son index
				myBlocks.remove(bloc);
				blockExist=true;
				break;
			}
		}
		if(blockExist==false) {
			//ajout � une liste de block
			myBlocks.add(block);
		}

		//on met la liste de block en session
		req.getSession().setAttribute("ListBlock", myBlocks);
		//on renvoie vers la servlet pour ajouter des figures
		resp.sendRedirect("AddFigure?id="+id);
	}



}
