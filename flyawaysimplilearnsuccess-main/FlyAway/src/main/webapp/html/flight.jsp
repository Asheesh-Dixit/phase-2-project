<%@page import="java.util.List"%>
<%@page import="com.flyaway.dto.Flight"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight</title>
<style>
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 50px;
  border :1px;
}

div {text-align: center;}
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<div style="text-align:right"><a href='changepassword.html'>
        <button class="btn">
            Change Password
        </button>
    </a></div>
    <div class="content">
     <h2>Flights</h2>
	<a href="flight/addflight.jsp"><button>Add Flight</button></a>
	<a href="flight/flightupdate.jsp"><button>Update Flight</button></a>
	<a href="flight/flightdelete.html"><button>Delete Flight</button></a><br>
	<table>
	<thead><td>id</td><td>FlightName</td><td>Airline</td><td>Source</td><td>Destination</td><td>Time</td><td>Price</td></thead>
    <%
		//session.getAttributeNames()
		List<Flight> allFlights = (List<Flight>)session.getAttribute("flights");
		for(Flight flight : allFlights){
			out.println("<tr>");
			out.println("<td>"+flight.getId() + "</td>");
			out.println("<td>"+flight.getFlight_name() + "</td>");
			out.println("<td>"+flight.getAirline() + "</td>");
			out.println("<td>"+flight.getSource() + "</td>");
			out.println("<td>"+flight.getDestination() + "</td>");
			out.println("<td>"+flight.getTime() + "</td>");
			out.println("<td>"+flight.getPrice() + "</td>");
			out.println("</tr>");
		}
	%>
	</table>
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>