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
<script type="text/javascript" src="js/jquery.json-2.4.min.js"></script>

</head>
<body>

	${msg}
	<div style="margin-left: 300px;">
		<form id="bid_form" action="doBiz" method="post">
			<select name='type'>
				<option value="buy" selected="selected">buy</option>
				<option value="sell">sell</option>
			</select>&nbsp;price: <input name="price" type="text" /> quantity: <input
				name="qty" type="text" /> <br> <br> <input type="submit"
				value="ok" style="width:100px" onclick="return checkForm();"> <input
				type="button" value="reset" onclick="reset();">
		</form>
	</div>

	<script type="text/javascript">
		function reset() {
			$("input").val('');
		}

		//setInterval("fetchTradeStatus()", 5000);
		function fetchTradeStatus() {
			$
					.get(
							"getMarketState",
							{},
							function(data) {
								var data = eval(data);
								$("#tradeDataTable").empty();
								$("#tradeDataTable")
										.append(
												"<tr><th>type</th><th>buyer</th><th>seller</th><th>initbid</th><th>dealprice</th><th>qty</th>"
														+ "<td>bidtime</td><td>dealtime</td></tr>");
								for ( var i = 0; i < data.length; i++) {
									$("#tradeDataTable")
											.append(
													"<tr><td>"
															+ data[i].status
															+ "</td><td>"
															+ data[i].buyer
															+ "</td><td>"
															+ data[i].seller
															+ "</td><td>"
															+ data[i].initbid
															+ "</td><td>"
															+ data[i].dealprice
															+ "</td><td>"
															+ data[i].qty
															+ "</td><td>"
															+ new Date(
																	parseInt(data[i].bidtime))
															+ "</td><td>"
															+ new Date(
																	parseInt(data[i].dealtime))
															+ "</td></tr>");
								}
							});
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
			} else {
				return true;
			}
		}
		function clearMarket() {
			$.get("clearMarket",{},function(data) {
				alert(data);
			});
		}
	</script>
	<br>
	<div style="margin-left: 100px;margin-top: 100px;">
		<button style="height: 30px; width: 180px"
			onclick="fetchTradeStatus();">refresh</button>
		<button style="height: 30px; width: 80px ; align: right;"
			onclick="clearMarket();">clear</button>
		<br>
		<table id="tradeDataTable" border="1">
		</table>
	</div>

</body>
</html>