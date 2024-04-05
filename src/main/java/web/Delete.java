package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("login") != null){
			String employe_id = request.getParameter("employe_id");
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_employes","root","0000");
				PreparedStatement statement=connection.prepareStatement("DELETE FROM EMPLOYES WHERE employe_id= ? ");
				statement.setString(1,employe_id);
				
				
				statement.executeUpdate();

				response.sendRedirect("employee.jsp");
				
				statement.close();
				connection.close();
				
				
				
			}catch(Exception e ) {
				System.out.println(e);
			}
			
			
			
			
		}else{
			response.sendRedirect("adminLog.jsp");
		}	
	}

	
}
