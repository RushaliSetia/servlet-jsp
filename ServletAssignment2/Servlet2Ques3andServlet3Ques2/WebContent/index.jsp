<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h1>Java FAQ Welcome Page</h1>
<p>If you are not yet registered, please <a href="registrationform.jsp">register</a><br/>
If you are registered please login<br/>
<form method="post" action="Registration">
Login Name<input type="text" name= "loginName"><br/>
Password<input type="password" name= "password"><br/>
<input type="submit" name="LoginButton" value="login">
</form>
</body>
</html>