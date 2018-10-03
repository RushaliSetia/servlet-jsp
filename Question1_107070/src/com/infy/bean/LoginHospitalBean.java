package com.infy.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.infy.utility.ConnectionProvider;

/* LoginHospitalBean class is used to hold methods that interact with data on the SQL server.*/
public class LoginHospitalBean {

	private Connection con;

	public LoginHospitalBean() throws NamingException, SQLException {

		con = ConnectionProvider.getConnection();
	}

	/*
	 * isValidate() method is used to check whether is existing username and
	 * password of the existing user is correct or not. It takes the username
	 * and password and returns a boolean value
	 */

	public boolean isValidate(String username, String password) {
		try {
			PreparedStatement st = con.prepareStatement(
					"SELECT * FROM HOSPITALLOGIN WHERE Hospital_UserName = ? AND Hospital_Password = ?");
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			} // end of if
			else {
				return false;
			} // end of else
		} // end of try block
		catch (Exception e) {
			e.printStackTrace();
		} // end of catch
		return false;
	}// end of isValidate() method
}// end of class
