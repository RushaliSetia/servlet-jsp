package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DAOOperations {
	
	DAOService db = new DAOService();
	PreparedStatement ps;
	
	public boolean insertData(String firstname, String lastname, String loginname, int age, String password, String topics) throws NamingException, SQLException
	{	
		boolean isInserted = false;
		Connection con = db.setConnection();
		ps = con.prepareStatement("insert into userdata values(?,?,?,?,?,?)");
		ps.setString(1, firstname);
		ps.setString(2, lastname);
		ps.setString(3, loginname);
		ps.setInt(4, age);
		ps.setString(5, password);
		ps.setString(6, topics);
		int inserted = ps.executeUpdate();
		System.out.println(inserted);
		if(inserted>0)
		{
			return isInserted=true;
		}
		else
		{
			return isInserted=false;
		}
		
		
	}//end insert
	
	public boolean validateUser(String loginname, String password) throws NamingException, SQLException
	{	
		boolean isValid = false;
		Connection con = db.setConnection();
		ps = con.prepareStatement("select * from  userdata where loginname=? and password=?");
		ps.setString(1,loginname);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			isValid = true;
			User u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
		}
		return isValid;
		
		
	}//end validateuser
	
	public User ShowUser(String loginname, String password) throws NamingException, SQLException
	{	
		User u = null;
		System.out.println("inside show user");
		Connection con = db.setConnection();
		ps = con.prepareStatement("select * from  userdata where loginanme=? and password=?");
		ps.setString(1,loginname);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			
			u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6));
		}
		return u;
		
		
	}//end showUser
	
	public boolean InsertQuestion(String loginname, int id, String question, String answer, String topic) throws NamingException, SQLException
	{	
		boolean isAdded = false;
		Connection con = db.setConnection();
		ps = con.prepareStatement("insert into question values(?,?,?,?,?)");
		ps.setString(1, loginname);
		ps.setInt(2, id);
		ps.setString(3, question);
		ps.setString(4, answer);
		ps.setString(5, topic);
		int inserted = ps.executeUpdate();
		System.out.println(inserted);
		if(inserted>0)
		{
			return isAdded=true;
		}
		else
		{
			return isAdded=false;
		}
		
	}

}
