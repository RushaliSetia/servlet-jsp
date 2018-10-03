package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.bean.User;

public class DaoOperation {

	public boolean registerUser(User user, String path) throws NamingException, SQLException {

		Connection con = DaoConnection.getConnection(path);

		String query = "insert into quizuser values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getAge());
		ps.setString(4, user.getTopic());
		int rs = ps.executeUpdate();
		if (rs > 0)
			return true;
		else
			return false;

	}

	public User checkUser(String userName, String password, String path) throws NamingException, SQLException {
		User user = new User();
		Connection con = DaoConnection.getConnection(path);
		String query = "select * from quizuser where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

			user.setUserName(userName);
			user.setPassword(password);
			user.setTopic(rs.getString(4));

			return user;
		} else {
			return null;
		}

	}

	public ResultSet getTopic(String path) throws NamingException, SQLException {

		Connection con = DaoConnection.getConnection(path);
		String query = "select distinct topic from quizuser";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		return rs;

	}
	
	
	
	public ResultSet getQuiz(String topic, String path) throws NamingException, SQLException{
	
		Connection con = DaoConnection.getConnection(path);
		
		String query="select * from quiz where topic = ?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, topic);
		ResultSet rs=ps.executeQuery();
		return rs;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
