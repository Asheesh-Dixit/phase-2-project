package com.flyaway.controllers.destinations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.DestinationDao;
import com.flyaway.dao.DestinationDaoImpl;
import com.flyaway.dto.Destination;


public class AddDestination extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destcity = request.getParameter("destination");
		String dsnt = request.getParameter("dsnt");
		
		Destination destination = new Destination(destcity, dsnt);
		DestinationDao dao = new DestinationDaoImpl();
		Integer id = dao.addDestination(destination);
		if(id > 0) {
			System.out.println("Destination added. id is : " + id);
		} else {
			System.out.println("Destination not added");
		}
		PrintWriter out = response.getWriter();
		out.println("Destination added Successfully");
		response.sendRedirect("GetAllDestinations");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
