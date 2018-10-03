package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserValidate;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection connection = UserValidate.getconnect();
		String username = (String) request.getAttribute("LoginId");
		String[] values= request.getParameterValues("id");
		out.println("<table><tr><th>loginId "+username +"</th></tr>");
			
		out.print("<tr><td> BookId </td><td> Bookname </td> <td> Price</td> <td>amount</td></tr>");
		for (String string : values) {
			try {
				PreparedStatement ps= connection.prepareStatement("select * from Bookinfo where BookId=?");
				ps.setString(1,string);
				ResultSet rs= ps.executeQuery();
				while(rs.next()){
					out.print("<tr><td>" +rs.getString(1) + "</td><td>"+rs.getString(2) + "</td><td>"+rs.getString(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
