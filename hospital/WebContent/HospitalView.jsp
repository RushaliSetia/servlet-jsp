<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.utility.ConnectionProvider,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if(session.getAttribute("user") == null){
		//if user is not logged in, it will redirect the user to login page with a message.
		response.sendRedirect("DoctorLogin.jsp?login=required");
	}
	%>
	Hospitals Schedule<br>
	Hello <%=(String)session.getAttribute("user") %>
	<br>
	Your Schedule is as follows<br>
	<%
	Connection conn = ConnectionProvider.getMyCon();
	try {
		PreparedStatement st1 = conn.prepareStatement("SELECT * FROM hospitalschedule WHERE name = ? AND ROWNUM <= 1");
		//query to find specialization of the Doctor
		st1.setString(1, (String)session.getAttribute("user"));
		ResultSet rs1 = st1.executeQuery();
		while(rs1.next()){
			//printing the specialization of doctor
			out.println("Specialization: "+rs1.getString(4));
		}
	} catch (Exception E) {
		E.printStackTrace();
	}
	%>
	
	<%
	Connection con = ConnectionProvider.getMyCon();
	try {
		PreparedStatement st = con.prepareStatement("SELECT * FROM hospitalschedule WHERE name = ?");
		//query to find the schedule of the logged in doctor.
		st.setString(1, (String)session.getAttribute("user"));
		ResultSet rs = st.executeQuery();
		//printing schedule in a table
		out.println("<table border='1'>");
		out.println("<tr><td>Day</td><td>Time</td></tr>");
		while(rs.next()){
			//used while loop to iterate the entries in schedule of doctor
			out.println("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td></tr>");
		}
		out.println("</table>");
	} catch (Exception E) {
		E.printStackTrace();
	}
	%>
	
</body>
</html>