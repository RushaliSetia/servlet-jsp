package p1;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertQuestion() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String loginname = (String) session.getAttribute("loginName");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String topic = request.getParameter("topic");
		int id = (int) (Math.random()+1);
		
		DAOOperations db = new DAOOperations();
		try {
			boolean added = db.InsertQuestion(loginname, id, question, answer, topic);
			if(added)
			{
				System.out.println("added");
			}
			else
			{
				System.out.println("not added");
			}
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
