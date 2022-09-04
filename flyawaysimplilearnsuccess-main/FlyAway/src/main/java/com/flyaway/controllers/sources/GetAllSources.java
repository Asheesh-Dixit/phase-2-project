package com.flyaway.controllers.sources;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.SourceDaoImpl;
import com.flyaway.dto.Source;


public class GetAllSources extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Source> allSources = new SourceDaoImpl().getAllSources();
		HttpSession session = request.getSession();
		if(allSources.size() > 0) {
			session.setAttribute("sources", allSources);
		} else {
			session.setAttribute("msg", "No Source data found");
		}
		
		response.sendRedirect("html/source.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
