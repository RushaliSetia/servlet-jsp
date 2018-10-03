<%@page import="com.dao.DaoOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
ServletContext ctx= getServletContext();
String path=ctx.getInitParameter("datasoursePath");
%>
<body>
<jsp:useBean id="user" class="com.bean.User" scope="session" />
<jsp:setProperty property="userName" name="user"/>
<jsp:setProperty property="password" name="user"/>
<jsp:setProperty property="age" name="user"/>
<jsp:setProperty property="topic" name="user"/>

<%
if(user.validateUser())
{
	DaoOperation obj=new DaoOperation();
	if(obj.registerUser(user, path)){
		
		response.sendRedirect("Home.jsp");
		
	}
	else{ %>
		
		Registration fail...... Go back to <a href="Home.jsp"></a>
		
<%	}


}

%>



</body>
</html>