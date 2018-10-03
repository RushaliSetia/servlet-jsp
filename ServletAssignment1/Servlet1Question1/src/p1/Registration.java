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
	
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String loginName = request.getParameter("loginname");
		int age = Integer.parseInt(request.getParameter("age"));
		String[] topic = request.getParameterValues("topic");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<html><body>");
		pw.println("<table><tr>");
		pw.print("<th>Firstname</th> <th>Lastname</th> <th>Loginname</th> <th>Age</th> <th>Topic</th></tr>");
		pw.print("<tr><td>" +fName +"</td> <td>"+ lName+ "</td> <td>" + loginName +"</td> <td>" +age+ "</td>");
		pw.print("<td>");
		for (String string : topic) {
			pw.println(string+ "<br/>");
		}
		pw.print("</td>");
		pw.println("</tr>");
		pw.write("</body></html>");
		
		
		
	}

}
