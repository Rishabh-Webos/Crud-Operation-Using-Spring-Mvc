<%@page import="com.employee.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateData" method="post">
		<%
			//ArrayList<Employee> listOfEmployee = (ArrayList<Employee>)request.getAttribute("listOfEmployee"); 
			try{
			    ArrayList<Employee> listOfEmployee = (ArrayList<Employee>)request.getAttribute("listOfEmployee");
			    for(Employee employee : listOfEmployee){
				    %>
				    	<input type="hidden" name="employeeId" value=<%=employee.getId() %>>
				    	Enter Name<input type="text" name="employeeName" value=<%=employee.getEmployeeName() %>><br>
				    	Enter Email<input type="text" name="employeeEmail" value=<%=employee.getEmployeeEmail() %>><br>
				    	Enter Password<input type="password" name="employeePassword" value=<%=employee.getEmployeePassword() %>><br>
				    	
						<input type="submit">
						</form>
				    <%
				}
			}
			catch(NullPointerException ex){
			    out.print(ex.getLocalizedMessage());
			}
		%>
</body>
</html>