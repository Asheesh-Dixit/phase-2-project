<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.content {
  max-width: 500px;
  margin: auto;
  padding-top: 100px;
  border :1px;
}

h2{text-align: left;}
div{text-align: center;}
</style>
</head>
<body>
	<div class="content">
	<h2>User Details:</h2>
	<form action="../PassengerDetails" method="post">
	<table>
		<tr><td>Name: </td><td><input type="text" name="name" /></td></tr>
		<tr><td>Gender: </td><td><input type="radio" name="gender" value="male"> Male
		<input type="radio" name="gender" value="female"> Female</td></tr>
		<tr><td>Age:  </td><td><input type="number" name="age" /></td></tr>
		<tr><td>Mobile Number: </td><td><input type="text" name="mobile" /></td></tr>
		<tr><td>Email id: </td><td><input type="text" name="email" /></td></tr>
	</table>
		<input type="hidden" value="<%request.getParameter("flightname");%>"/>
		<div><input type="submit" value="Submit"/></div>
	
	</form>
	</div>
	<br><br>
<div style="text-align: center;"></div>
</body>