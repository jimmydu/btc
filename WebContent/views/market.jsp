<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>market</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

</head>
<body>

	${msg}
	<div align="center">
		<form id="bid_form" action="doBiz">
			<select name='type'>
				<option value="buy" selected="selected">buy</option>
				<option value="sell">sell</option>
			</select><br> <br>price: <input name="price" type="text" /> <br> <br>
			quantity: <input name="qty" type="text" /> <br> <input
				type="button" value="ok" onclick="submitForm();">
			<input type="button" value="reset" onclick="reset();">
		</form>
	</div>

	<script type="text/javascript">
		function reset() {
			$("input").val('');
		}
		function submitForm() {
			if($("input[name='price']").val() == '' || $("input[name='qty']").val() == '')
				alert("invalid input");
			else 
				$("#bid_form").submit();
		}
	</script>
	<table border="1">
		<tr>
			<th>bid order</th>
			<th>price</th>
		</tr>


	</table>

</body>
</html>