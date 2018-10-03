package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class submitQuiz
 */
public class submitQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public submitQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		int i = 1;
		String answer;
		String correctAns;
		int score = 0;
		while (i <= 5) {

			answer = request.getParameter("answer" + i);
			correctAns = request.getParameter("correctAns" + i);
			System.out.println(answer);
			if (answer.equals(correctAns)) {
				score++;
			}
			i++;
		}
		if(score<3){
			
			out.println("Result : Fail . Try again after 10 days <a href='Home.jsp'>Go back to Home Page </a> ");
		}
		else if(score==5)
		{
		 response.sendRedirect("movieTicket.jsp");
		}
		else{
			out.println("nice try <a href='Home.jsp'>Go back to Home Page </a> ");
		}
	}

}
