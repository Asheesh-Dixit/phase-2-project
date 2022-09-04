<%@page import="com.flyaway.dto.Destination"%>
<%@page import="com.flyaway.dao.DestinationDaoImpl"%>
<%@page import="com.flyaway.dao.SourceDaoImpl"%>
<%@page import="com.flyaway.dto.Source"%>
<%@page import="com.flyaway.dto.Airline"%>
<%@page import="com.flyaway.dao.AirlineDaoImpl"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Flight</title>
<style>
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 100px;
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
	<h2>Provide details of flight to be updated</h2>
	<form action="../../UpdateFlight" method="post">
		Id:
		<input type="text" name="id"/><br>
		
		Airline Name: 
		<select name="airline" id="airline">
  		<%
		//session.getAttributeNames()
		Set<Airline> allAirlines = new AirlineDaoImpl().getAllAirlines();
		for(Airline airline : allAirlines){
			out.println("<option value='"+airline.getName()+"'>"+airline.getName()+"</option>");
		}
		%>
  		</select><br>
  		Flight Name:
		<input type="text" name="flight_name"/><br>
		Source: 
		<select name="source" id="source">
  		<%
		//session.getAttributeNames()
		Set<Source> allSources = new SourceDaoImpl().getAllSources();
		for(Source source : allSources){
			out.println("<option value='"+source.getSource()+"'>"+source.getSource()+"</option>");
			
		}
		%>
		</select><br>
		Destination: 
		<select name="destination" id="destination">
  		<%
		//session.getAttributeNames()
		Set<Destination> allDestinations = new DestinationDaoImpl().getAllDestinations();
		for(Destination destination : allDestinations){
			out.println("<option value='"+destination.getDestination()+"'>"+destination.getDestination()+"</option>");	
		}
		%>
		</select><br>
		Date of Travel:
		<input type="time" name="time"/><br>
		Price:
		<input type="text" name="price"/><br>
		<input type="submit"/>
	</form>
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>