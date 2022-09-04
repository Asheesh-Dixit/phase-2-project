<%@page import="com.flyaway.dto.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout Page</title>
<style type="text/css">
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 100px;
  border :1px;
}


</style>

</head>
<body>
	
	<% 	List<Flight> flights = (List<Flight>) session.getAttribute("flights"); 
		for(Flight flight : flights){
			session.setAttribute("price", flight.getPrice());
			session.setAttribute("flightname", flight.getFlight_name());
			session.setAttribute("airline", flight.getAirline());
			session.setAttribute("time", flight.getTime());
		}
		Integer n = Integer.parseInt((String)session.getAttribute("persons"));
		Integer p = Integer.parseInt((String)session.getAttribute("price"));
		Integer total = n*p;
		session.setAttribute("total", total);
	%>
	<div class="content">
	<h2>Ticket Booking</h2>
	<h3>Ticket Details: </h3>
	From <strong><%= session.getAttribute("source") %></strong> to <strong><%= session.getAttribute("destination") %></strong>
					<p>No. of Passengers: <%= session.getAttribute("persons") %></p>
					<p>Total cost: <%= session.getAttribute("persons") %> x <%= session.getAttribute("price") %> = Rs. <%= total %></p>
	<h3>Card Details: </h3>
	<form action="../CardDetails" method="post">
		<table>
			<tr><td>Card Number:</td> <td>
			<input type="number"id="cardnum" name="cardnum" required></td></tr>
			<tr><td>Name on Card:</td> <td><input
				type="text" id="cardname" name="cardname" required></td></tr>
			<tr><td>Expiry Date:</td> <td><input
				type="number" min="1" max="12"><input
				type="number" min="2022" max="2027"></td></tr>
			
		
		
		</table>
		<input type="submit" value="Checkout">				
	</form>
	
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>