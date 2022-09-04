package com.flyaway.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.dao.UserDao;
import com.flyaway.dao.UserDaoImpl;
import com.flyaway.dto.User;

/**
 * Servlet implementation class ValidateUserServlet
 */
public class ValidateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		UserDao dao = new UserDaoImpl();
		boolean isUserValid = dao.validateUser(user);
		if(isUserValid)
			response.sendRedirect("html/admin.html");
		else
			response.sendRedirect("html/invaliduser.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
