package com.sopra.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		
		if(request.getSession().getAttribute("username")==null && request.getRequestURI().equals("/Tetris/home")) {
			chain.doFilter(request, response);
		}
		else if(request.getSession().getAttribute("username")==null && !request.getRequestURI().equals("/Tetris/home")){
			response.sendRedirect("/Tetris/home");
		}
		else if(request.getSession().getAttribute("username")!=null) {
			chain.doFilter(request, response);
		}

	}

}
