<%--CHƯA LÀM XONG --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multiplication table</title>
<!-- sử dụng jstl với el -->
</head>
<body>
<h1>Multiplication table</h1>
<form method="post" >
	<label for="number">Number</label> 
	<select name="number" id="number">
		<option value="5">5</option>
		<option value="7">7</option>
		<option value="9">9</option>
		<option value="11">11</option>
	</select>
	<input type="submit" value="view" />
</form>

</body>
</html>