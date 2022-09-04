package com.flyaway.controllers.route;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.RouteDaoImpl;
import com.flyaway.dto.Route;


public class GetAllRoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Route> allRoutes = new RouteDaoImpl().getAllRoutes();
		HttpSession session = request.getSession();
		if(allRoutes.size() > 0) {
			session.setAttribute("routes", allRoutes);
		} else {
			session.setAttribute("msg", "No Route data found");
		}
		
		response.sendRedirect("html/route.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
