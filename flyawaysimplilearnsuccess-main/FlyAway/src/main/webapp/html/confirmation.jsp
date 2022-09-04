<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
<style type="text/css">
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 100px;
  border :1px;
}

div {text-align: center;}
table, th{
  border: 1px solid black;
}
</style>

</head>
<body>
	<div class="content">
	<h2>Thank You!</h2>
	<p>Your ticket has been booked for <strong><%= session.getAttribute("source") %></strong> to <strong><%= session.getAttribute("destination") %></strong></p>
	<table>
	<thead><tr><td>Ticket Details:</td></tr></thead>
	<tr><td>Date of Travel: </td><td> <%= session.getAttribute("date") %></td></tr>
	<tr><td>Flight Name: </td><td> <%= session.getAttribute("flightname") %></td></tr>
	<tr><td>Airline: </td><td><%= session.getAttribute("airline") %></td></tr>
	<tr><td>Time: </td><td><%= session.getAttribute("time") %></td></tr>
	</table><br>
	
	<table>
	<thead><tr><td>Passenger Details:</td></tr></thead>
	<tr><td>Booking Name: </td><td><%= session.getAttribute("name") %> </td></tr><tr><td> Email: </td><td><%= session.getAttribute("email") %>
	</td></tr><tr><td> Mobile: </td><td><%= session.getAttribute("mobile") %></td></tr>
	</table>
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>