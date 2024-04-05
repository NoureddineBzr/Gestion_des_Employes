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
		<h1>Employee management</h1>
		<table border="1" width = "100%">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Date of hire</th>
					<th>salary</th>
					<th>job</th>
					<th>department</th>
						
				</tr>
				<%	

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_employes","root","0000");
					PreparedStatement statement=connection.prepareStatement("SELECT * FROM EMPLOYES");
					
					ResultSet result = statement.executeQuery();
					while(result.next()){
						%>
							<tr>
								<td><%=result.getString(1) %></td>
								<td><%=result.getString(2) %></td>
								<td><%=result.getString(3) %></td>
								<td><%=result.getString(4) %></td>
								<td><%=result.getString(5) %></td>
								<td><%=result.getString(6) %></td>
								<td><%=result.getString(7) %></td>
								<td><%=result.getString(8) %></td>
							</tr>
						
						<% 
					}	
					result.close();
					statement.close();
					connection.close();
					
					
					
				}catch(Exception e ) {
					System.out.println(e);
				}
				%>
				
		</table>
		<a href="addEmployee.jsp">Add an Employee </a>
	</div>


</body>
</html>