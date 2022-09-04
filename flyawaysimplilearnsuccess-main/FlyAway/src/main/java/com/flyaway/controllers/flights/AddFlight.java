package com.flyaway.controllers.flights;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.FlightDao;
import com.flyaway.dao.FlightDaoImpl;
import com.flyaway.dto.Flight;


public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flight_name = request.getParameter("flight_name");
		String airline = request.getParameter("airline");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String time =  request.getParameter("time");
		String price = request.getParameter("price");

		Flight flight = new Flight(flight_name, airline, source, destination, time, price);
		FlightDao dao = new FlightDaoImpl();
		Integer id = dao.addFlight(flight);
		if(id > 0) {
			System.out.println("Flight added. id is : " + id);
			PrintWriter out = response.getWriter();
			
			response.sendRedirect("GetAllFlights");
			out.println("<script>alert('Flight Updated Suceessfully');</script>");
		} else {
			System.out.println("Flight not added");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
