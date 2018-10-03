<%@ page import ="com.solution1.UserValidate" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="user" class="com.solution1.UserValidate" scope="session">
	<jsp:setProperty property="*" name="user"/>	
</jsp:useBean>




<% 
   boolean userStatus = user.isValidUser();
   
   if(userStatus==true)
   {
		 session = request.getSession(true);
		 session.setAttribute("username", user.getUserName());
	   	%>
	   	<jsp:forward page="BookCatalougeServlet"></jsp:forward>
	   	<%
   }
   
   else
   {
   	session.setAttribute("errorMsg", "Invalid User");
   	%>
   	<jsp:forward page="error.jsp"></jsp:forward>
   	<%
   }
   %>

</body>
</html>