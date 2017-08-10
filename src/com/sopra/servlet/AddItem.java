package com.sopra.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.model.Tetrimino;

@WebServlet("/newitem")
public class AddItem extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Tetrimino> myTetriminoList = (List<Tetrimino>)request.getSession().getAttribute("myTetriminoList");
		
		
	}

}
