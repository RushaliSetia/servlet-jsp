package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class TopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String[] topics = request.getParameterValues("topic");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		for(String s: topics)
		{	
			System.out.println("name of topic "+s);
			if(s.equalsIgnoreCase("Date and Times"))
			{	
				response.sendRedirect("DateAndTime?topicName="+s+"");
			}
			else if(s.equalsIgnoreCase("Strings and StringBuffers"))
			{	
				response.sendRedirect("StringAndBuffer?topicName="+s+"");
			}
			else if(s.equalsIgnoreCase("Threading"))
			{	
				response.sendRedirect("Threading?topicName="+s+"");
			}
		}
		ArrayList<Questions> queList = new ArrayList<Questions>();
		session.setAttribute("arrayList", queList);
		
	}

	
}
