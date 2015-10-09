<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>Add Employee</title>
</head>
<body>
<h1>
	Login
</h1>
<form:form action="add.html" method="post" commandName="emp">
<table>
<tr>
		<td>
			<form:label path="empID">
				<spring:message text="Employee ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="empID" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Employee Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="designation">
				<spring:message text="Designation"/>
			</form:label>
		</td>
		<td>
			<form:input path="designation" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="contactNo">
				<spring:message text="Contact No"/>
			</form:label>
		</td>
		<td>
			<form:input path="contactNo" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
				<input type="submit" value="<spring:message text="Add"/>" />
		</td>
	</tr>
</table>	
</form:form>


</body>
</html>