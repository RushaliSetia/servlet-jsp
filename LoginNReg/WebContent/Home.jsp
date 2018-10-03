<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DaoOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.getRequestDispatcher("Logout.jsp").include(request, response);
%>
<% 
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
DaoOperation obj=new DaoOperation();
ResultSet rs=obj.getTopic(path);
%>
<h2>Registration Form</h2>
<form action="Register.jsp" method="post">
User Name : <input type="text" name="userName"><br>
Password : <input type="password" name="password"><br>
Age : <input type="text" name="age"><br>
Topic : <select name="topic">
<% while(rs.next()) { %>
<option value=<%= rs.getString(1) %>><%= rs.getString(1) %> </option>
<% } %>

</select>
<input type="submit" value="Register">
</form>

<h2>Login Form</h2>
<form action="Validate" method="post">
Username :  <input type="text" name="userName"><br>
Password : <input type="password" name="password"><br>
<input type="submit" value="Login">
</form>
</body>
</html>