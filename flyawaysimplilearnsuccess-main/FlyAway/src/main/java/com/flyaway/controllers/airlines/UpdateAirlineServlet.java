package com.flyaway.controllers.airlines;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.AirlineDao;
import com.flyaway.dao.AirlineDaoImpl;


public class UpdateAirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String iata = request.getParameter("iata");
		AirlineDao dao = new AirlineDaoImpl();
		dao.updateAirline(id, name, iata);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Airline Updated Suceessfully');</script>");
		response.sendRedirect("GetAllAirlinesServlet");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
