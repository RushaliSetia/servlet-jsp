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
<title>Display Title</title>
</head>
<body>

<table border = "1">
<tr>
<th> Title </th>
<th> Buy </th>
</tr>


<%
	Connection connection = Connect.getconnect();
	PreparedStatement ps = connection.prepareStatement("select title from CD");
	ResultSet rs= ps.executeQuery();
	while(rs.next()){
		%> <tr><td><a href="TitleDetail.jsp?name=<%=rs.getString(1)%>"> <%=rs.getString(1)%> </a></td><td> <a href="Customer.jsp?title=<%=rs.getString(1)%>">Buy</a></td></tr><%
	}
%>




</body>
</html>