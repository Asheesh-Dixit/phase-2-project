package com.flyaway.controllers.flights;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AirlineDao;
import com.flyaway.dao.AirlineDaoImpl;
import com.flyaway.dao.FlightDao;
import com.flyaway.dao.FlightDaoImpl;
import com.flyaway.dto.Flight;


public class UpdateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"))  ;
		String flight_name = request.getParameter("flight_name");
		String airline = request.getParameter("airline");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String time =  request.getParameter("time");
		String price = request.getParameter("price");

		//Flight flight = new Flight(flight_name, airline, source, destination, date_of_travel, price);
		FlightDao dao = new FlightDaoImpl();
		dao.updateFlight(id, flight_name, airline, source, destination, time, price);
		PrintWriter out = response.getWriter();
		
		response.sendRedirect("GetAllFlights");
		out.println("<script>alert('Airline Updated Suceessfully');</script>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
