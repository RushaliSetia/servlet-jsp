<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="valid" class="util.UserValidate"></jsp:useBean>
<jsp:setProperty property="*" name="valid"/>

<% 
if(valid.isValid()){
	request.setAttribute("LoginId", valid.getUsername());
	RequestDispatcher rd = request.getRequestDispatcher("BookCatalogeServlet");
	rd.forward(request,response);
}
else{
	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
	rd.forward(request, response);
}



%>

</body>
</html>