<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Logged In</title>
</head>
<body>
	<a href="add.html">Add Employee</a>
	<br>
	<br>
<h3>Employee List</h3>
<c:if test="${!empty listEmp}">
	<table>
	<tr>
		<td>Employee ID</td>
		<td>Name</td>
		<td>Designation</td>
		<td>Contact No</td>
		<td colspan="2">Operations</td>
		
	</tr>
	<c:forEach items="${listEmp}" var="empl">
	
		<tr>
			<td>${empl.empID}</td>
			<td>${empl.name}</td>
			<td>${empl.designation}</td>
			<td>${empl.contactNo}</td>
			<td><a href="<c:url value='/update/${empl.empID}' />" >Update</a></td>
			<td><a href="<c:url value='/delete/${empl.empID}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
	
</body>
</html>