package com.sopra.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.dao.IPlayerDAO;
import com.sopra.dao.ITetriminoDAO;
import com.sopra.exception.FormValidationException;
import com.sopra.model.Player;
import com.sopra.model.Tetrimino;

@WebServlet("/newplayer")
public class AddPlayer extends HttpServlet {
	@EJB
	private IPlayerDAO PlayerDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Renvoyer vers la JSP
		this.getServletContext().getRequestDispatcher("/WEB-INF/PlayerRegistration.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean error = false;

		// Creation d'un Joueur
		Player myNewPlayer = new Player();
		myNewPlayer.setLastName(request.getParameter("lastNamePlayer"));
		try {
			validationLastName(myNewPlayer.getLastName());
		}catch(FormValidationException fve) {
			request.setAttribute("lastNamePlayer", fve);		
			error =true;
			
		}
		myNewPlayer.setName(request.getParameter("namePlayer"));
		try {
			validationName(myNewPlayer.getName());
		}catch(FormValidationException fve) {
			request.setAttribute("namePlayer", fve);		
			error =true;
		}
		
		myNewPlayer.setPassword(request.getParameter("passwordPlayer"));
		try {
			validationPwd(myNewPlayer.getPassword());
		}catch(FormValidationException fve) {
			request.setAttribute("passwordPlayer", fve);		
			error =true;
		}
		
		myNewPlayer.setUsername(request.getParameter("username"));
		try {
			validationUsername(myNewPlayer.getUsername());
		}catch(FormValidationException fve) {
			request.setAttribute("username", fve);
			error = true;
		}
		
		if(error==false) {
		
			Player newPlayer = new Player();
			newPlayer = PlayerDAO.add(myNewPlayer);
			response.sendRedirect("displayplayer");
		}
		else {
			//response.sendRedirect("newitem");
			this.doGet(request, response);
		}
		
	}

	private void validationName(String nom) throws FormValidationException{
		if(nom.equals("")) {
			throw new FormValidationException("Please enter a name !");
		}
	}
	
	private void validationLastName(String lastName) throws FormValidationException{
		if(lastName.equals("")) {
			throw new FormValidationException("Please enter a lastname!");
		}
	}
	private void validationUsername(String username) throws FormValidationException{
		if(username.equals("")) {
			throw new FormValidationException("Please enter a username");
		}
	}
	private void validationPwd(String pwd) throws FormValidationException{
		if(pwd.equals("")) {
			throw new FormValidationException("Please enter a password !");
		}
		else if(pwd.length()<6) {
			throw new FormValidationException("Your password must have at least 6 letters or Symbols");
		}
	}
}

