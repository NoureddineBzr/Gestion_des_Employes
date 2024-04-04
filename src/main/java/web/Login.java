package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("username");
		String password = request.getParameter("pwd");
		
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_employes","root","0000");
			PreparedStatement statement=connection.prepareStatement("SELECT admin_id FROM ADMIN WHERE nom = ? and mot_de_passe = ?");
			statement.setString(1,login);
			statement.setString(2,password);
			
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				session.setAttribute("login", login);
				response.sendRedirect("employee.jsp");
				
		
				
			}else {
				response.sendRedirect("adminLog.jsp");
			
			
				
			}
			result.close();
			statement.close();
			connection.close();
			
			
			
		}catch(Exception e ) {
			System.out.println(e);
		}
		
	
	}

}
