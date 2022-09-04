<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.dto.Destination"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Destination</title>
<style>
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 30px;
  border :1px;
}

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
    <h2>Destinations</h2>
	<a href="destination/adddestination.html"><button>Add Destination</button></a>
	<a href="destination/destinationupdate.html"><button>Update Destination</button></a>
	<a href="destination/destinationdelete.html"><button>Delete Destination</button></a><br>
	<table>
	<thead><td>id</td><td>Destination</td><td>Short Name</td></thead>
    <%
		//session.getAttributeNames()
		Set<Destination> allDestinations = (Set<Destination>)session.getAttribute("destinations");
		for(Destination destination : allDestinations){
			out.println("<tr>");
			out.println("<td>"+destination.getId() +"</td>");
			out.println("<td>"+destination.getDestination() +"</td>");
			out.println("<td>"+destination.getDsnt() +"</td>");
			out.println("</tr>");
		}
	%>
	</table>
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>