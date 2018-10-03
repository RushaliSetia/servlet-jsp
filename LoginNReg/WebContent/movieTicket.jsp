<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
HttpSession session=request.getSession();
String userName="";
if(session==null){
	
	response.sendRedirect("Home.jsp");
}
else{
	userName=(String)session.getAttribute("userName");
	
}
Date d= new Date();
SimpleDateFormat fd= new SimpleDateFormat("dd-MMM-yyyy");
String date=fd.format(d);
%>


congo!! <%= userName %> <br>
<h2> You have won Movie Ticket on <%= date %>  </h2>
</body>
</html>