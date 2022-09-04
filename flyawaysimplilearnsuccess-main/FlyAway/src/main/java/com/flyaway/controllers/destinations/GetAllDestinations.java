package com.flyaway.controllers.destinations;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.DestinationDaoImpl;
import com.flyaway.dto.Destination;


public class GetAllDestinations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Destination> allDestinations = new DestinationDaoImpl().getAllDestinations();
		HttpSession session = request.getSession();
		if(allDestinations.size() > 0) {
			session.setAttribute("destinations", allDestinations);
		} else {
			session.setAttribute("msg", "No Destination data found");
		}
		
		response.sendRedirect("html/destination.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
