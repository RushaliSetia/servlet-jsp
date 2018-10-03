package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserValidate;


public class BookCatalogeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username =(String) request.getAttribute("LoginId");
		request.setAttribute("username", username);
		HashSet<String> set = new HashSet<>();
		Connection connection = UserValidate.getconnect();
		PrintWriter out= response.getWriter();
		try {
			PreparedStatement ps= connection.prepareStatement("select Category from Bookinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				set.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("LoginId : " +username+ "<br>");
		out.println("Book Category <br>");
		for (String string : set) {
			out.println("<a href='PurchaseBookServlet?category="+string+" &LoginId="+username+"'>"+string+"</a><br>");	
		}
		out.println("<a href='ShowCartServlet'>Show Cart</a><br>");
		out.println("<a href='Login.jsp'>Logout</a><br>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
