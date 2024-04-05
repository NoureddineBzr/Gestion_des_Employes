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
	<div>
		<h1>Add an Employee</h1>
		<form action="Add" method="POST">
		    <label for="first_name">First Name:</label><br>
		    <input type="text" id="first_name" name="first_name" required><br><br>
		
		    <label for="last_name">Last Name:</label><br>
		    <input type="text" id="last_name" name="last_name" required><br><br>
		
		    <label for="email">Email:</label><br>
		    <input type="email" id="email" name="email" required><br><br>
		
		    <label for="date_of_hire">Date of Hire:</label><br>
		    <input type="date" id="date_of_hire" name="date_of_hire" required><br><br>
		
		    <label for="salary">Salary:</label><br>
		    <input type="number" id="salary" name="salary" required><br><br>
		
		    <label for="job">Job:</label><br>
		    <input type="text" id="job" name="job" required><br><br>
		
		    <label for="department">Department:</label><br>
		    <input type="text" id="department" name="department" required><br><br>
		
		    <input type="submit" value="Submit">
  </form>
	</div>

</body>
</html>