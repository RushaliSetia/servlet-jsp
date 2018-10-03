package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserValidate {
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	
	public boolean isValid(){
		boolean state= false;
		Connection connection =UserValidate.getconnect();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Logininfo");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(this.username) && rs.getString(2).equals(this.password)){
					
					state=true;
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
		
	}
}
