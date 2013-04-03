<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User list</title>
</head>
<body>
	<div align="center" style="margin-top: 100px">
		User ID: ${userID} <br>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>age</th>
				<th>gender</th>
			</tr>

			<c:forEach var="item" items="${userList}">
				<tr>
					<td>${item.userid}</td>
					<td>${item.name}</td>
					<td>${item.age}</td>
					<td>${item.sex}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>