<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DaoOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
HttpSession session= request.getSession();
String userName=(String)session.getAttribute("userName");


%>
Welcome <%= userName %> <br>

<%
String topic="";
 if(session==null){
	response.sendRedirect("Home.jsp");
	}
else{
	 topic=(String)session.getAttribute("topic");
	if(topic.equals("")||topic==null){
		response.sendRedirect("Home.jsp");
		
	}
} 
topic=(String)session.getAttribute("topic");
System.out.println(topic);
DaoOperation obj=new DaoOperation();
ResultSet rs=obj.getQuiz(topic, path);
%>
<form action="submitQuiz" method="post">
<%
int counter =1;
while(rs.next() && counter<=5){
%>
<br>
<%= counter %> ) <%= rs.getString(2) %> <br>
<input type="radio" name=<%= "answer"+counter %> value='a'><%= rs.getString(3) %><br>
<input type="radio" name=<%= "answer"+counter %> value='b'><%= rs.getString(4) %><br>
<input type="radio" name=<%= "answer"+counter %> value='c'><%= rs.getString(5) %><br>
<input type="radio" name=<%= "answer"+counter %> value='d'><%= rs.getString(6) %><br>
<input type="hidden" name= <%= "correctAns"+counter %> value=<%= rs.getString(7) %>>

<% 
counter++;
} %>

<input type="submit" value="Submit"><br>
<input type="submit" value="Reset">
</form>




</body>
</html>