package util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connect {
	static Connection con;
	public static Connection getconnect(){
		 try{
		Context ctx = new InitialContext();
		DataSource ds= (DataSource) ctx.lookup("java:comp/env/jdbc/myTestDBCP");
		con=ds.getConnection();
		  }catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
}
