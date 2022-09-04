<%@page import="com.flyaway.dto.Airline"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline</title>
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
    <h2>Airlines</h2>
	<a href="airline/addairline.html"><button>Add Airline</button></a>
	<a href="airline/airlineupdate.html"><button>Update Airline</button></a>
	<a href="airline/airlinedelete.html"><button>Delete Airline</button></a><br>
	<div style="text-align: center;"><table>
	<thead><td>id</td><td>IATA</td><td>Name</td></thead>
    <%
		//session.getAttributeNames()
		Set<Airline> allAirlines = (Set<Airline>)session.getAttribute("airlines");
		for(Airline airline : allAirlines){
			out.println("<tr>");
			out.println("<td>"+airline.getId() + "</td>");
			out.println("<td>"+airline.getIata() + "</td>");
			out.println("<td>"+airline.getName() + "</td>");
			out.println("</tr>");
		}
	%>
	</table></div>
	</div>
	<br><br>
	<div style="text-align: center;"></div>
</body>
</html>