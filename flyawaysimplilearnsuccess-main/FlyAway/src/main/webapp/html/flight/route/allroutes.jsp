<%@page import="com.flyaway.dto.Airline"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Airline</title>
</head>
<body>
	
	<%
		//session.getAttributeNames()
		Set<Airline> allAirlines = (Set<Airline>)session.getAttribute("airlines");
		for(Airline airline : allAirlines){
			out.println(airline + "<br/>");
		}
	%>
</body>
</html>