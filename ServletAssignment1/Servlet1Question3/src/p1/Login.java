package p1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<User> user = new ArrayList<>();
       
   
    public Login() {
        super();   
        user.add(new User("sakshi", "sakshi"));
        user.add(new User("apoorv", "apoorv"));
        user.add(new User("shivani", "shivani"));        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int counter = 0;
		
		for(User u : user)
		{
			if(u.getUserName().equalsIgnoreCase(name))
			{ 
				if(u.getPassword().equalsIgnoreCase(password))
				{
					counter++;
					request.setAttribute("username",name );
					request.setAttribute("password", password);
					RequestDispatcher rd = request.getRequestDispatcher("UserInfo");
					rd.forward(request, response);
				}
			}
		}
		
		if(counter == 0)
		{
			response.sendRedirect("index.html");
		}
	}

}
