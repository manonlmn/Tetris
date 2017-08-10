package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.TetriminoDAO;
import com.sopra.model.Tetrimino;

@WebServlet("/newitem")
public class AddItem extends HttpServlet {
	
	List<Tetrimino> myTetriminoList;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération de la liste mise à jour des tétriminos
		myTetriminoList = (List<Tetrimino>)request.getSession().getAttribute("myTetriminoList");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myTetriminoList = (List<Tetrimino>)request.getSession().getAttribute("myTetriminoList");

		// Création d'un Tétrimino en récupérant les attributs de formulaire
		Tetrimino myNewTetrimino = new Tetrimino();
		myNewTetrimino.setNameTetrimino((String)request.getSession().getAttribute("nameNewTetrimino"));
		myNewTetrimino.setColourTetrimino((String)request.getSession().getAttribute("colourNewTetrimino"));
		
		// Envoi du tétrimino à la DAO
		TetriminoDAO.add(myNewTetrimino);
	}

}
