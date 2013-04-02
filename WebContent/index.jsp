<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BTC</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>
<body>
	Hello Jimmy!
	<a href="hello">hello</a>
	<br> Input user ID:
	<input id="userID" type="text"/>
	<input type="button" value="get User" onclick="getUser();">
	<script type="text/javascript">
		function getUser() {
			window.location.href='getUser?userID='+$("#userID").val();
		}
	</script>
	
</body>
</html>