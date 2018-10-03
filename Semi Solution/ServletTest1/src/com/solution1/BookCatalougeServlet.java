package com.solution1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class BookCatalougeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		try {
		
			DatabaseOperationQuestion1 db = new DatabaseOperationQuestion1();
			List<String> bookCategory = db.getBookCategory();
			HttpSession session = request.getSession(false); // fetch the previous session build at Validate.jsp
			
			PrintWriter out= response.getWriter();
			
			   out.println("<html>");
	    	   out.println("<head>");
	    	   out.println("<center><h1>Book Catalogue</h1></scenter>");
	    	   out.println("</head>");
	    	   out.println("<body>");
	    	   out.println("<p> Welcome "+userName+"");
	    	   out.println("<br/><p><u>Book Category </u></p>");
	    	   
	    	   out.print("<li>");
	    	   // getting data from database
	    	   for (String category : bookCategory) {
				   out.println("<ol><a href ='PurchaseBookServlet?category="+category+"'>"+category+"</a></ol>");
		       }
	    	   
	    	   out.print("</li>");
	    	   
	    	   out.println("<br><a href ='ShowCartServlet'>ShowCart");
	    	   out.println("<br><a href ='Logout?category='Logout'>Logout");
	    	   out.println("</body>");
	    	   out.println("</html>");

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
			 	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		/*String userName= request.getParameter("userName");
		String generalCategory ="General";
		String computerCategory ="Computer"; //
		   PrintWriter out= response.getWriter();
	
	
			   out.println("<html>");
	    	   out.println("<head>");
	    	   out.println("<h1>Book Catalogue</h1>");
	    	   out.println("</head>");
	    	   out.println("<body>");
	    	   out.println("<br><p>Login ID :"+userName+"");
	    	   out.println("<p>Book Category :</p>");
	    	   out.println("<a href ='PurchaseBookServlet?category="+computerCategory+"'>Computer");
	    	   out.println("<br><a href ='PurchaseBookServlet?category="+generalCategory+"'>General");
	    	   out.println("<br><a href ='ShowCartServlet'>ShowCart");
	    	   out.println("<br><a href ='Logout?category='Logout'>Logout");
	    	   out.println("</body>");
	    	   out.println("</html>");
*/			
	}

}
