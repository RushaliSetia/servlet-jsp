package com.utility;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/*
 * Connection Provider Class. This class is used to hold methods that initialize the connection with SQL server.
 * 
 * Paste the following in context.xml file in ~apache-tomcat-7.0\conf\context.xml
 * ------------------------------------------------------------------------------
 <Resource name="jdbc/myoracle" auth="Container" type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
  url="jdbc:oracle:thin:@127.0.0.1:1521:xe" username="hr" password="hr"/>
 * ------------------------------------------------------------------------------           
 */
public class ConnectionProvider {
	static Connection con=null;
	
	/*
	 * getMyCon Method is used to create the connection with SQL server using Connection Pooling.
	 * @return Connection con
	 */
	public static Connection getMyCon() {
		try
		{   
			Context initContext = new InitialContext();
	    	 Context envContext  = (Context)initContext.lookup("java:/comp/env");
	    	 DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	    	 con=ds.getConnection();
	    
		}catch(Exception e)
		
		{
			System.out.println(e.toString());
			
		}
		
		return con;
	}

}
