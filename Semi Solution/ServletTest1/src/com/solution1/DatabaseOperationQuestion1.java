package com.solution1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public class DatabaseOperationQuestion1 {
	
	Connection con;
	
	DatabaseOperationQuestion1()throws NamingException,SQLException
	{
		con = DatabaseService.getConnection();
	}
	
	public boolean validateUser(String username,String password)throws SQLException
	{
		
		boolean flag = false;
		username = username.trim();
		password = password.trim();
		System.out.println("------->> Username "+username+" & "+" Password "+password);
		con.commit();
		String quary = "select * from LoginInfo where loginid=? and password=?";
		PreparedStatement ps = con.prepareStatement(quary);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		System.out.println("------>> Query Executed ResultSet : "+rs);
		int x=0;
		while(rs.next())
		{
			x++;
		}
		if(x>0)flag = true;
		return flag;
	}
	
	public List<String> getBookCategory()throws SQLException
	{
		List<String> bookCategory = new ArrayList<String>();
		
		con.commit();
		String quary = "select distinct(category) from bookInfo";
		PreparedStatement ps = con.prepareStatement(quary);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			bookCategory.add(rs.getString(1));
		}
		
		return bookCategory;
	}
	
}//end class
