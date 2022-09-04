package com.flyaway.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.flyaway.dao.FlightDao;
import com.flyaway.dao.FlightDaoImpl;
import com.flyaway.dto.Flight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchResults() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
		String persons = request.getParameter("persons");
		
		HttpSession session = request.getSession();
		session.setAttribute("source", source);
		session.setAttribute("destination", destination);
		session.setAttribute("date", date);
		session.setAttribute("persons", persons);
		
		FlightDao dao = new FlightDaoImpl();
		List<Flight> flights = dao.searchFlights(source, destination);
		session.setAttribute("flights", flights);
		response.sendRedirect("html/searchresults.jsp");
	}

}
