<%@ page language="java"%>
<%@ page import="java.sql.*" %>
<%
String log="";
	if(session.getAttribute("login") != null){
		log = session.getAttribute("login").toString();
	}else{
		response.sendRedirect("adminLog.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		Bonjour <%=log %> <br>
		<a href="logOut">Logout</a>
		
	</div>


</body>
</html>