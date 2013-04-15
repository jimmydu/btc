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
<script type="text/javascript" src="js/jquery.form.js"></script>

</head>
<body>

	${msg}
	<div style="margin-left:300px">
		<form id="bid_form" action="doBiz" method="post">
			<select name='type' >
				<option value="buy" selected="selected">buy</option>
				<option value="sell">sell</option>
			</select>&nbsp;price: <input name="price" type="text" />
			quantity: <input name="qty" type="text" /> <br><br> <input
				type="submit" value="ok" onclick="return checkForm();"> <input
				type="button" value="reset" onclick="reset();">
		</form>
	</div>

	<script type="text/javascript">
		function reset() {
			$("input").val('');
		}
		
		setInterval("fetchTradeStatus()", 5000);
		function fetchTradeStatus() {
			//alert('Should fetch status from Trade table...');
		}
		$(document).ready(function() {
			$("#bid_form").ajaxForm(function(data) {
				alert(data);
			});
		});
		function checkForm() {
			if ($("input[name='price']").val() == ''
					|| $("input[name='qty']").val() == '') {
				
				alert("invalid input");
				return false;
			}
			else {
				return true;	
			}
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