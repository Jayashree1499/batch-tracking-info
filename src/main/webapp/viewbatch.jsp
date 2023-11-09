<%@page import="com.bti.dto.Batch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  
	List<Batch> batches=(List<Batch>)request.getAttribute("batchlist"); 
	for(Batch batch:batches ){
	
	%>
		<table border="2px solid red">
		<tr>
			<td><%=batch.getUser().getId() %></td>
			<td><%=batch.getBatch_id() %></td>
			<td><%=batch.getCreateDate() %></td>
			<td><%=batch.getStatus() %></td>
			<td><%=batch.getSubject() %></td>
		
		</tr>
		
		
		
		</table>
	
	
	<%} %>
</body>
</html>