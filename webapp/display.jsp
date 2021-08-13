<%@page import="com.employee.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<%ArrayList<Employee> listOfEmployee = (ArrayList)request.getAttribute("listOfEmployee"); 
		for(Employee employee : listOfEmployee){
		    %>
		    	<tr>
		    		<td><%=employee.getEmployeeName() %></td>
		    		<td><%=employee.getEmployeeEmail() %></td>
		    		<td><%=employee.getEmployeePassword() %></td>
		    		<td><a href="update?id=<%=employee.getId()%>">Update</a></td>
		    		<td><a href="delete?id=<%=employee.getId()%>">Delete</a></td>
		    	</tr>
		    <%
		}
	%>
	</table>
</body>
</html>