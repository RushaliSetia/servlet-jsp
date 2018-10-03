package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertServlet() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(10*60);
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String loginName = request.getParameter("loginname");
		int age = Integer.parseInt(request.getParameter("age"));
		String password = loginName.substring(0, 4)+(int)((Math.random()*9)+1);
		String[] topics = request.getParameterValues("topic");
		String str = "";
		for(String s : topics)
		{
			str = str+ s+ ",";
		}
		String topic = str.substring(0, str.length()-1);
		System.out.println(topic);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		DAOOperations db = new DAOOperations();
		try {
			boolean value = db.insertData(firstName, lastName, loginName, age, password, topic);
			System.out.println(value);
			if(value)
			{	
				
				session.setAttribute("loginName", loginName);
				User u = db.ShowUser(loginName, password);
				System.out.println(u.toString());
				pw.print("<html><body>");
				pw.print("<p>Firstname = " +u.getFirstName()+"<br/>");
				pw.print("Lastname = " +u.getSurname()+"<br/>");
				pw.print("Age = " +u.getAge()+"<br/>");
				pw.print("password = " +u.getPassword()+"</p><br/>");
				pw.print("You selected these topics: <br/>");
				String[] t = u.getTopics().split(",");
				for(String s: t)
				{
					pw.print(s+"<br/>");
				}
				session.setAttribute("topics", t);
				pw.print("<br/>Go to <a href='TopicList'>topic List page</a>");
				pw.print("</body></html>");
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
		} catch (NamingException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
