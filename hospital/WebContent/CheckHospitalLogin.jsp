<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.bean.LoginHospitalBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//getting parameters from DoctorLogin Page
		String username = request.getParameter("loginname");
		String password = request.getParameter("password");
		LoginHospitalBean lb = new LoginHospitalBean();
		if(lb.isValidate(username, password)){
			//login success
			session.setAttribute("user", username);
			response.sendRedirect("HospitalView.jsp");
		}else{
			//login failed
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>