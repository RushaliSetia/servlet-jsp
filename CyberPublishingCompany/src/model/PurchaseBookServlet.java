package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserValidate;

/**
 * Servlet implementation class PurchaseBookServlet
 */
public class PurchaseBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String category=request.getParameter("category");
		String username= request.getParameter("LoginId");
		out.println("<table border='1'><tr><th>LoginId  " +username + "</th><th>Category " +category + "</tr>");
	
		Connection connection = UserValidate.getconnect();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from bookinfo");
			ResultSet rs = ps.executeQuery();
			out.print("<form action='ShowCartServlet' method='get'>");
			out.println("<tr><th> BookId </th> <th> Book Name</th> <th>Author Name </th> <th>Price </th> <th >Price</th></tr>");
			while(rs.next()){
				
				out.println("<tr><td>"+rs.getString(1) + "</td><td>" +rs.getString(2)+ "</td><td>" + rs.getString(4) + "</td><td>" +rs.getInt(5) + "</td><td><input type='checkbox' name='id' value="+rs.getString(1)+">");
				
	
			}
				request.setAttribute("Login", username);
				//String[] values = request.getParameterValues("id");
			out.println("<tr><td> <a href='BookCatalogeServlet'>Back</a></td> <td> <input type='submit'></form></td> <td><a href='Login.jsp'>Logout</td><td><a href='ShowCartServlet'> Show Cart</a></td></tr></table>");
			
		//	System.out.println(values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
