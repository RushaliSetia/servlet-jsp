package com.solution1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class PurchaseBookServlet
 */
public class PurchaseBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category= (String)request.getParameter("category");
		String  userName = null;
		 HttpSession session = request.getSession(false);
		if(session != null)
		{
			userName= (String) session.getAttribute("username");
			
		}
	
		String bookId;
		String bookName;
		
		String authorName;
		double price;
		 
		 
		   PrintWriter out= response.getWriter();
		try{
		   Connection con =null;
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
				ctx.lookup("java:comp/env/jdbc/myTestDBCP");
			
			con = ds.getConnection();	
			
			PreparedStatement ps = con.prepareStatement("select * from  BookInfo where Category=?");
			ps.setString(1,category);
			
	
			 out.println("<html>");
	    	   out.println("<head>");
	    	   out.println("</head>");
	    	   out.println("<body>");
	    	   out.println("<form method='post' action='ShowCartServlet'>");
	    	   out.println("<table>");
	    	   out.println("<thead>");
	    	   out.println("<tr>");
	    	   out.println("<th>Login ID:'"+userName+"'</th>");
	    	   out.println("<th>category:'"+category+"'</th>");
	    	   out.println("</tr>");
	    	   out.println("</thead>");
	    	   out.println("<tfoot>");
	    	   out.println("<tr>");
	    	   out.println("<th><a href='BookCatalougeServlet'>BAck</th>");
	    	   out.println("<th><input type='submit' value='Submit'></th>");
	    	   out.println("<th><a href='Logout'>Logout</th>");
	    	   out.println("<th><a href='ShowCartServlet'>ShowCart</th>");
	    	  out.println("</tr>");
	    	   out.println("</tfoot>");
	    	   out.println("<tbody>");
	    	   out.println("<tr>");
	    	   out.println("<th>BookID</th>");
	    	   out.println("<th>Book Name</th>");
	    	   out.println("<th>Author Name</th>");
	    	   out.println("<th>Price</th>");
	    	   out.println("<th>Purchase</th>");
	    	   out.println("</tr>");
			ResultSet rs = ps.executeQuery();
	      while(rs.next())
	        {
	    	   bookId=rs.getString(1);
	    	   bookName=rs.getString(2);
	    	   category=rs.getString(3);
	    	   authorName=rs.getString(4);
	    	   price=rs.getDouble(5);   
	    	   out.println("<tr>");
	    	   out.println("<th>"+bookId+"</th>");
	    	   out.println("<th>"+bookName+"</th>");
	    	   out.println("<th>"+authorName+"</th>");
	    	   out.println("<th>"+price+"</th>");
	    	   out.println("<th><input type='checkbox' name='purchase' value='"+price+"'></th>");
	    	   out.println("</tr>");
	    	   
	        }
	      out.println("</tbody>");
	      out.println("</table>");
	      out.println("</form>");
	      out.println("</body>");
   	      out.println("</html>");
		}catch(Exception e)
		{
			out.print("Following Exception Occured"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
