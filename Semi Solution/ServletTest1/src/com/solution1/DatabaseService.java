package com.solution1;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseService {

	public static Connection getConnection()throws NamingException,SQLException
	{
		Connection con =null;
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)
			ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		
		con = ds.getConnection();	
		
		return con;
		
	}
}
