package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class TopicList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		request.getAttribute("loginName");
		HttpSession session = request.getSession(false);
		if(session!= null)
		{
			response.sendRedirect("DisplayList");
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
		
	}

	

}
