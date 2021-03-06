package com.sopra.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/api/*")
public class FilterApi implements javax.servlet.Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	//verification de tous les joueurs au lieu des admins
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		if(request.getSession().getAttribute("username")==null && (request.getRequestURI().equals("/Tetris/api/player/login"))) {
			chain.doFilter(request, response);
		}
		else if(request.getSession().getAttribute("username")!=null) {
			chain.doFilter(request, response);
		}
	}

}
