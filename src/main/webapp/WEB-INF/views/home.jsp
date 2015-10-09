<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<h1>
	Login
</h1>
<form:form action="login.html" method="post" commandName="person">
<table>
<tr>
		<td>
			<form:label path="username">
				<spring:message text="User Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="username" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
				<input type="submit" value="<spring:message text="Login"/>" />
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>
