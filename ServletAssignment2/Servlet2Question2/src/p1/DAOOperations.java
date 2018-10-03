package p1;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DAOOperations {
	
	DAOService db = new DAOService();
	PreparedStatement ps;
	
	public boolean validateUser(String username, String password) throws NamingException, SQLException
	{	
		boolean valid= false;
		Connection con = db.setConnection();
		ps=con.prepareStatement("Select * from userTable where loginName=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		valid = ps.execute();
		return valid;
	}
	
	public ResultSet viewUser(String username, String password) throws NamingException, SQLException
	{
		Connection con = db.setConnection();
		ps=con.prepareStatement("Select * from userTable where loginName=? and password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		return rs;
		
	}

}
