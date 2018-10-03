package p1;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.DaoOperation;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		String datasoursePath = ctx.getInitParameter("datasoursePath");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		DaoOperation obj=new DaoOperation();
		try {
			User user=obj.checkUser(userName, password,datasoursePath);
			if(user!=null){
				HttpSession session=request.getSession(true);
				session.setAttribute("userName", userName);
				session.setAttribute("password", password);
				session.setAttribute("topic", user.getTopic());
				response.sendRedirect("Welcome.jsp");
				
			}
			else{
				response.sendRedirect("Home.jsp");
				
			}
			
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
