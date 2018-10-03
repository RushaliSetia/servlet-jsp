package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String loginName = (String)request.getAttribute("username");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><body>");
		pw.print("<p>Can't login for the user: " +loginName +"</p>");
		pw.print("<p>Incorrect login name or password</p>");
		pw.print("</body></html>");
	}

}
