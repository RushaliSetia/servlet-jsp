<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// the following scriptlet tag is checking whether user got redirected from other page or not
if(request.getParameter("login") != null && request.getParameter("login").equals("required"))
	out.println("You need to login first!");
%>

Current Date and Time: <%=new Date() %><!--  It is showing the current Date and time on top of page-->
	<form method="POST" action="CheckHospitalLogin.jsp">
		<table>
			<tr>
				<td>Doctor's Login Name</td>
				<td><input type="text" name="loginname"></td>
			</tr>
			<tr>
				<td>Doctor's Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Log In"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>