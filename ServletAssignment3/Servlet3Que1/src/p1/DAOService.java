package p1;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOService {
	
Connection con;
	
	public Connection setConnection() throws NamingException, SQLException
	{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		return con = ds.getConnection();	
	}	

}