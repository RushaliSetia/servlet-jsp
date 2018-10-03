package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Threading extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Threading() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String t = request.getParameter("topicName");
		pw.print("<html><body>");
		pw.print("<h1 align='center'>"+t+"</h1>");
		pw.print("Question<input type='text' name= 'question'>");
		pw.print("Answer<input type='text' name= 'answer'>");
		pw.print("<input type='hidden' name= 'topic' value="+t+">");
		pw.print("<input type='submit' name='submit' value='submit'>");
		pw.print("<input type='submit' name='submit' value='Enter more'>");
		pw.print("<input type='submit' name='submit' value='back'></form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String buttonName = request.getParameter("submit");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String topic = request.getParameter("topic");
		String loginname = (String) session.getAttribute("loginName");
		int id = (int) (Math.random()+1);
		request.setAttribute("question", question);
		request.setAttribute("answer", answer);
		request.setAttribute("topic", topic);
		if(buttonName.equals("submit"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("InsertQuestion");
			rd.forward(request, response);
		}
		else if(buttonName.equals("Enter more"))
		{
			ArrayList<Questions> list = (ArrayList<Questions>) session.getAttribute("arrayList");
			list.add(new Questions(loginname, id, question, answer, topic));
			System.out.println(list);
			response.sendRedirect("Threading?topicName="+topic+"");
						
		}
		else if(buttonName.equals("back"))
		{
			response.sendRedirect("TopicList");
		}
	}
	

}
