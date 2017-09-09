<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Login</title>
</head>
<body>

	<h1>Login</h1>

	<h3>Enter user name and password:</h3>
	<%
String error = (String)request.getAttribute("error");
%>
	<form name='f'
		action="${pageContext.request.contextPath}/login"
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>