package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.model.Block;

@WebServlet("/resetFigure")
public class ResetFigure extends ServletInChief {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//on récupère le numéro d'id du tetrimino concerné par l'ajout de figures 
		int id=Integer.parseInt(request.getParameter("id"));
		
		//on récupère la liste des blocks non enregistrés
		List<Block> blocks = (List<Block>) request.getSession().getAttribute("ListBlock");
		//on vide la liste de blocks
		blocks.clear();
		//on la renvoie en session
		request.getSession().setAttribute("ListBlock", blocks);
		//on retourne sur la servlet pour ajouter des figures
		resp.sendRedirect("AddFigure?id="+id);
	}
	
	

}
