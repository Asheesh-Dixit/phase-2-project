package com.flyaway.controllers.route;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.RouteDao;
import com.flyaway.dao.RouteDaoImpl;


public class UpdateRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String src = request.getParameter("src");
		String dsnt = request.getParameter("dsnt");
		RouteDao dao = new RouteDaoImpl();
		dao.updateRoute(id, source, destination, src, dsnt);
		response.sendRedirect("GetAllRoutesServlet");
		//response.sendRedirect("html/route/routeupdatesuccess.html");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
