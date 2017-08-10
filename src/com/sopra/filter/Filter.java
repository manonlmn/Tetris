package com.sopra.filter;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		
		if(request.getSession().getAttribute("nameUser")==null && request.getRequestURI().equals("/tp1/home")) {
			chain.doFilter(request, response);
		}
		else if(request.getSession().getAttribute("nameUser")==null && !request.getRequestURI().equals("/tp1/home")){
			response.sendRedirect("/tp1/home");
		}
		else if(request.getSession().getAttribute("nameUser")!=null) {
			chain.doFilter(request, response);
		}

	}

}
