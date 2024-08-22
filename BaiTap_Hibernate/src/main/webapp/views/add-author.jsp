<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Author</title>
</head>
<body>
<h1>Add Author</h1>
<form action="${pageContext.request.contextPath}/AddAuthorServlet" method="post">
	<p><label>Name: </label><input type="text" name="name" /></p>
	<p><input type="submit" name="btnSave" value="Save" /></p>
</form>
</body>
</html>