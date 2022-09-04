<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.dto.Source"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Source</title>
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
    </a>
    </div>
    <div class="content">
	<h2>Sources</h2>
	<a href="source/addsource.html"><button>Add Source</button></a>
	<a href="source/sourceupdate.html"><button>Update Source</button></a>
	<a href="source/sourcedelete.html"><button>Delete Source</button></a><br>
	<table>
	<thead><tr><td>id</td><td>Source</td><td>Short Name</td></tr></thead>
    <%
		//session.getAttributeNames()
		Set<Source> allSources = (Set<Source>)session.getAttribute("sources");
		for(Source source : allSources){
			out.println("<tr>");
			out.println("<td>"+source.getId() +"</td>");
			out.println("<td>"+source.getSource() +"</td>");
			out.println("<td>"+source.getSrc() +"</td>");
			out.println("</tr>");
		}
	%>
	</table>
	</div><br><br>
<div style="text-align: center;"></div>
	
</body>
</html>