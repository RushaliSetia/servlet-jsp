package com.solution1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class UserValidate {

	String userName;
	String userPassword;
	
	public UserValidate()//default constructor
	{
      		
	}

	//parameterised  constructor
	public UserValidate(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		
		//System.out.println("userName ="+userName);
	}

	
	//getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public  boolean isValidUser() throws NamingException, SQLException
	{
		System.out.println("---->>inside bean : "+this.userName+" and "+this.userPassword);
		DatabaseOperationQuestion1 dbOj = new DatabaseOperationQuestion1();
		boolean userStatus = dbOj.validateUser(this.userName,this.userPassword);
		return userStatus;		
	
	}
	
}
