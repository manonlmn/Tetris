package com.sopra.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sopra.dao.IFigureDAO;
import com.sopra.model.Figure;
import com.sopra.model.Tetrimino;

@WebServlet("/leftOffsetFigure")
public class LeftOffsetFigure extends ServletInChief {
	private static final long serialVersionUID = 1L;
    
	@Autowired
	private IFigureDAO myFigureDAO;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Figure myFigure = myFigureDAO.search(Integer.parseInt(request.getParameter("id")));
		int myListFiguresSize = myFigure.getTetrimino().getMyFigures().size();
		
		for(Figure figure : myFigure.getTetrimino().getMyFigures()) {
			if(figure.getRotationNumber() != ((myFigure.getRotationNumber()-1)%4)+1) {
				myFigure.setRotationNumber(((myFigure.getRotationNumber()-1)%4)+1);
				}
			else {
				int cpt;
				cpt = figure.getRotationNumber();
				figure.setRotationNumber(myFigure.getRotationNumber()-1);
				myFigure.setRotationNumber(((myFigure.getRotationNumber()-1)%4)+1);
				myFigureDAO.modify(figure);
			}
		}
		myFigureDAO.modify(myFigure);
		response.sendRedirect("/Tetris/ListFiguresTetrimino?id="+myFigure.getTetrimino().getIdTetrimino());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
