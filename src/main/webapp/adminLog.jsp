	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	 <link rel="stylesheet" type="text/css" href="Style.css">
	<title>Login</title>
	</head>
	 <body>
	 
	        <div class="box">	
	          <h2>LOGIN</h2>
	          <form method="POST" action="Login">
	            <div class="inputBox">
	              <input type="text" name="username" required></input>
	              <label>Username</label>
	            </div>
	            <div class="inputBox">
	              <input type="password" name="pwd" required></input>
	              <label>Password</label>
	            </div>
	            <input type="submit" name="" value="Submit">
	    
	          </form>
	          
	       </div>
	    
	      </body>
	</html>