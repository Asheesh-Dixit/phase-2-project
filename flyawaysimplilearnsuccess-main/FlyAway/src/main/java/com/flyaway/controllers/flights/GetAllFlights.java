package com.flyaway.controllers.flights;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.FlightDaoImpl;
import com.flyaway.dto.Flight;


public class GetAllFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Flight> allFlights = new FlightDaoImpl().getAllFlights();
		System.out.println("allFlights :"+ allFlights);
		HttpSession session = request.getSession();
		if(allFlights.size() > 0) {
			session.setAttribute("flights", allFlights);
		} else {
			session.setAttribute("msg", "No flight data found");
		}
		
		response.sendRedirect("html/flight.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
