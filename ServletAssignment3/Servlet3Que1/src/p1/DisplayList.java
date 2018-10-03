package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayList
 */
public class DisplayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if(session!= null)
		{
			String[] t = (String[]) session.getAttribute("topics");
			pw.print("<html><body>");
			for(String s: t)
			{
				pw.print("<a href=''>"+s+"</a><br/>");
			}
		}
	}

	

}
