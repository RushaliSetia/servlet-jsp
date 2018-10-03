package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Connect;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String address  = request.getParameter("ship");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Connection connection = Connect.getconnect();
		try {
			PreparedStatement ps = connection.prepareStatement("select Quantity from CD where Title=?");
			ps.setString(1, title);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				
				if(rs.getInt(1)>=quantity){
					PreparedStatement ps1= connection.prepareStatement("insert into Customer values(?,?,?)");
					ps1.setString(1,username);
					ps1.setString(2,address);
					ps1.setString(3,title);
					int i= ps.executeUpdate();
					if(i>0){
						RequestDispatcher rd= request.getRequestDispatcher("Welcome.html");
						rd.forward(request, response);
					}
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	}

}
