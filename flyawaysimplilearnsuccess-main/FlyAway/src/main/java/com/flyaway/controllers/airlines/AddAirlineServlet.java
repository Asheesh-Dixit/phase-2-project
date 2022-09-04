package com.flyaway.controllers.airlines;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AirlineDao;
import com.flyaway.dao.AirlineDaoImpl;
import com.flyaway.dto.Airline;


public class AddAirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String iata = request.getParameter("iata");
		
		Airline airline = new Airline(name, iata);
		AirlineDao dao = new AirlineDaoImpl();
		Integer id = dao.addAirline(airline);
		if(id > 0) {
			System.out.println("Airline added. id is : " + id);
			PrintWriter out = response.getWriter();
			out.println("<script>alert('Airline Updated Suceessfully');</script>");
			response.sendRedirect("GetAllAirlinesServlet");
		} else {
			System.out.println("Airline not added");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
