<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.infy.bean.LoginHospitalBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>check hospital login</title>
</head>
<body>
	<%
		//getting parameters from DoctorLogin Page
		String username = request.getParameter("loginname");
		String password = request.getParameter("password");
		LoginHospitalBean lb = new LoginHospitalBean();
		if (lb.isValidate(username, password)) {
			//on successful login of the doctor the details will be printed for the particular doctor.
			session.setAttribute("user", username);
			response.sendRedirect("HospitalView.jsp");
		} else {
			//if the login is then failed then the error page will be displayed.
			response.sendRedirect("Error.jsp");
		}
	%>
</body>
</html>