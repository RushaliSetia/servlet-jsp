package com.infy.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/* ConnectionProvider class is used to create the Connection*/
public class ConnectionProvider {

	static Connection con = null;

	public static Connection getConnection() throws NamingException, SQLException {
		Context ctx;

		ctx = new InitialContext();
		DataSource ds;
		ds = (DataSource) ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		con = ds.getConnection();

		return con;
	}// end of getConnection() method

}// end of class
