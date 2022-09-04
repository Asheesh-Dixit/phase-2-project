package com.flyaway.controllers.sources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.SourceDao;
import com.flyaway.dao.SourceDaoImpl;


public class UpdateSource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String source = request.getParameter("source");
		String src = request.getParameter("src");
		SourceDao dao = new SourceDaoImpl();
		dao.updateSource(id, source, src);
		response.sendRedirect("GetAllSources");
		//response.sendRedirect("html/source/sourceupdatesuccess.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
