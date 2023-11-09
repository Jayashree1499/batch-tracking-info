<%@page import="com.bti.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}

li {
	display: inline;
}

a {
	display: block;
	padding: 8px;
	background-color: #dddddd;
}
</style>
</head>
<body>
	<h1>WELCOME HR</h1>
	<table border="10px">
		<%
		List<User> users = (List<User>) request.getAttribute("list_1");
		for (User ele : users) {
		%>
		<tr>
			<td><%=ele.getName()%></td>
			<td><%=ele.getEmail()%></td>
			<td><%=ele.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="addtrainee.jsp">AddTrainer</a>
</body>
</html>