package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("LoginButton");
		if(button.equalsIgnoreCase("login"))
		{
			String name = request.getParameter("loginName");
			String password = request.getParameter("password");
			DAOOperations d = new DAOOperations();
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			
				try {
					boolean check = d.validateUser(name, password);
					if(check)
					{	System.out.println(check);
						ResultSet rs = d.viewUser(name, password);
						System.out.println(rs.getString(1));
						pw.println("FirstName = "+rs.getString(1));
						pw.println("LastName = "+rs.getString(2));
						pw.println("LoginName = "+rs.getString(3));
						pw.println("Age = "+rs.getInt(4));
						pw.println("Password = "+rs.getString(5));
					}
					else
					{
						response.sendRedirect("index.html");
					}
				} catch (NamingException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}//end if
	}//end doPost

}
