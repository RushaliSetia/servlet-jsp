<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>
</head>
<body>
<form method= "post" action= "InsertServlet">
First Name<input type = "text" name= "firstname" required><br/>
Last Name<input type = "text" name= "lastname" required><br/>
Login Name<input type = "text" name= "loginname" required><br/>
Age<input type = "text" name= "age" required><br/>
Which topics are you interested in?<br/><input type= "checkbox" name = "topic" value= "Date and Times">Date and Times<br/>
<input type= "checkbox" name = "topic" value= "Strings and StringBuffers">Strings and StringBuffers<br/>
<input type= "checkbox" name = "topic" value= "Threading">Threading<br/>
<input type="submit" value="Submit">
</form>
</body>
</html>