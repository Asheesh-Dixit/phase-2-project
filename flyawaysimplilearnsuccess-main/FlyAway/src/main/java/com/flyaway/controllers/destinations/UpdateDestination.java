package com.flyaway.controllers.destinations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.DestinationDao;
import com.flyaway.dao.DestinationDaoImpl;


public class UpdateDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String destination = request.getParameter("destination");
		String dsnt = request.getParameter("dsnt");
		DestinationDao dao = new DestinationDaoImpl();
		dao.updateDestination(id, destination, dsnt);
		response.sendRedirect("GetAllDestinations");
		//response.sendRedirect("html/destination/destinationupdatesuccess.html");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
