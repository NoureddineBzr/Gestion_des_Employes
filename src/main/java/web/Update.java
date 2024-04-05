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

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null) {
            String employe_id = request.getParameter("employee_id");
            String firstName = request.getParameter("first_name");
            String lastName = request.getParameter("last_name");
            String email = request.getParameter("email");
            String dateOfHire = request.getParameter("date_of_hire");
            String salary = request.getParameter("salary");
            String job = request.getParameter("job");
            String department = request.getParameter("department");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_employes",
                        "root", "0000");
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE EMPLOYES SET nom=?, prenom=?, email=?, date_embauche=?, salaire=?, poste=?, departement=? WHERE employe_id=?");
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, dateOfHire);
                statement.setString(5, salary);
                statement.setString(6, job);
                statement.setString(7, department);
                statement.setString(8, employe_id);

                statement.executeUpdate();

                response.sendRedirect("employee.jsp");

                statement.close();
                connection.close();

            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            response.sendRedirect("adminLog.jsp");
        }
    }

   
}
