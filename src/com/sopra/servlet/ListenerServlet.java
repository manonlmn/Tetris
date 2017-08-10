package com.sopra.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sopra.model.Tetrimino;

@WebListener
public class ListenerServlet implements ServletContextListener {
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	// Initialising empty Tetriminos' list and adding as Attribute
    	List<Tetrimino> myTetriminoList = new ArrayList<Tetrimino>();
		sce.getServletContext().setAttribute("myTetriminoList", myTetriminoList);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    }


	
}
