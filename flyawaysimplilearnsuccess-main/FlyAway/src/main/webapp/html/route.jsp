<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.dto.Route"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Route</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<a href="route/addroute.html"><button>Add Route</button></a>
	<a href="route/routeupdate.html"><button>Update Route</button></a>
	<a href="route/routedelete.html"><button>Delete Route</button></a><br>
	<table>
	<thead><td>id</td><td>Source</td><td>Destination</td></thead>
    <%
		//session.getAttributeNames()
		Set<Route> allRoutes = (Set<Route>)session.getAttribute("routes");
		for(Route route : allRoutes){
			out.println("<tr>");
			out.println("<td>"+route.getId() +"</td>");
			out.println("<td>"+route.getSource() +"</td>");
			out.println("<td>"+route.getDestination() +"</td>");
			out.println("</tr>");
		}
	%>
	</table>
</body>
</html>