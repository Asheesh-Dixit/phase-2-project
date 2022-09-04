package com.flyaway.controllers.sources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.SourceDao;
import com.flyaway.dao.SourceDaoImpl;
import com.flyaway.dto.Source;

public class AddSource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("source");
		String src = request.getParameter("src");
		
		Source source = new Source(city, src);
		SourceDao dao = new SourceDaoImpl();
		Integer id = dao.addSource(source);
		if(id > 0) {
			System.out.println("Source added. id is : " + id);
		} else {
			System.out.println("Source not added");
		}
		PrintWriter out = response.getWriter();
		out.println("Source added Successfully");
		response.sendRedirect("GetAllSources");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
