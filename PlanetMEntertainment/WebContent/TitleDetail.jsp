<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.Connect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Title detail</title>
</head>
<body>
	<%
	Connection connection = Connect.getconnect();
	String name= request.getParameter("name");
	
	PreparedStatement ps= connection.prepareStatement("select * from cd where Title=?");
	ps.setString(1, name);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		out.print("Title / Artist / Company / Country / Price / Year / Quantity <br>");
		out.print(rs.getString(1) + " /" +rs.getString(2) + " /" +rs.getString(3) + " /" +rs.getString(4) + " /" +rs.getString(5) + " /" +rs.getString(6) + " /" +rs.getString(7));
	}
	%>
	<br>
	<a href="DisplayTitle.jsp">back</a>
</body>
</html>