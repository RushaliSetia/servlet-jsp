package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Registration() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String loginName = request.getParameter("loginname");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] topic = request.getParameterValues("topic");
		
		User user = new User(fName, lName, loginName, age, topic);
		if(user!=null)
		{	
			pw.println("Welcome " +user.getFirstName()+ "<br/>");
			pw.println(user.toString());
		}
		
		else
		{
			pw.print("You have entered wrong value");
		}
		
	}

}
