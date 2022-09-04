<%@page import="com.flyaway.dto.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

.content {
  max-width: 900px;
  margin: auto;
  padding-top: 100px;
  border :1px;
}


table, th, td {
  border: 1px solid black;
  text-align: center;
}
</style>
</head>

<body>
	<div class="content">
	<h2>Search Results</h2>
	<table>
		<tr>
			<th>Flight Number</th>
			<th>Airline</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>Time</th>
			<th>Ticket Price</th>
			<th>Select</th>
		</tr>
		<%
			List<Flight> flights = (List<Flight>) session.getAttribute("flights");
			for(Flight flight : flights)
			{
				out.print("<tr>");
				out.print("<td>"+ flight.getFlight_name() +"</td>");
				out.print("<td>"+ flight.getAirline() +"</td>");
				out.print("<td>"+ flight.getSource() +"</td>");
				out.print("<td>"+ flight.getDestination() +"</td>");
				out.print("<td>"+ session.getAttribute("date") + "</td>");
				out.print("<td>"+ flight.getTime() + "</td>");
				out.print("<td>"+ flight.getPrice() +"</td>");
				//session.setAttribute("flightname", flight.getFlight_name());
				out.print("<td><a href='passenger.jsp?flightname="+flight.getFlight_name()+"}' class='btn btn-primary'>"+ "Select Flight" +"</a></td>");
				out.print("</tr>");
			}
		%>
		</tr>
	</table>
	</div>
	<br><br>
<div style="text-align: center;"></div>
</body>
</html>