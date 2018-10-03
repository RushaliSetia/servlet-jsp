package com.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utility.ConnectionProvider;
/*
 * LoginHospitalBean Class is created to hold methods that interact with data on the SQL server.
 */
public class LoginHospitalBean {
	private Connection con;
	public LoginHospitalBean(){
		con = ConnectionProvider.getMyCon();
	}
	
	/*
	 * isValidate method is used to find whether the username and password are correct or not
	 * @param String username
	 * @param String password
	 * 
	 * @return boolean (true/false)
	 */
	public boolean isValidate(String username, String password){
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM hospitallogin WHERE hospital_username = ? AND hospital_password = ?");
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return false;
	}
	
}
