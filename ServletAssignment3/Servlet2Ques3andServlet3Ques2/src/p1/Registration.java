package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("LoginButton");
		if(value.equalsIgnoreCase("login"))
		{
			String loginName = request.getParameter("loginName");
			String password = request.getParameter("password");
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			DAOOperations db = new DAOOperations();
			try {
				boolean user = db.validateUser(loginName, password);
				if(user)
				{	
					User u = db.ShowUser(loginName, password);
					pw.print("<html><body>");
					pw.print("<p>Firstname = " +u.getFirstName()+"<br/>");
					pw.print("<p>Lastname = " +u.getSurname()+"<br/>");
					pw.print("<p>Age = " +u.getAge()+"<br/>");
					
				}
				else
				{
					request.setAttribute("username", loginName);
					RequestDispatcher rd = request.getRequestDispatcher("ErrorServlet");
					rd.forward(request, response);
				}
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}//end if
		
		else
		{
			response.sendRedirect("index.jsp");
		}
	}//end post
	}

