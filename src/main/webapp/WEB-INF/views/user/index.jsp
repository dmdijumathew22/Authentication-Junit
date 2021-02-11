<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Search user</title>
</head>
<body>
	<div align="center">
		<h2>User Search</h2>

		<div style="color:red">${msg}</div>
		<form id="find" action="${pageContext.request.contextPath }/user/login" method="post">
			<table style="with: 50%">
				<tr>
					<td>Enter User ID</td>
					
					<td><input type="text" name="userid"  /></td>
				</tr>	
				<tr><td> Enter password</td>	
					<td><input type="text" name="pwd"  /></td>
				</tr>
				<tr>	
					<td><input type="submit" value="login" /></td>
				</tr>
			</table>
		</form>
		
		
	</div>
</body>
</html>