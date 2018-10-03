<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer details</title>
</head>
<body>
	<%
	String title= request.getParameter("title");
	%>
<form action="RegisterServlet" method="post">
	Title <input type="text" name="title" value="<%=title%>">
	Customer Name <input type="text" name="username">
	Shipping Address<input type="text" name="ship">
	Quantity <input type="number" name="quantity">
	<input type="submit">
	</form>
</body>
</html>