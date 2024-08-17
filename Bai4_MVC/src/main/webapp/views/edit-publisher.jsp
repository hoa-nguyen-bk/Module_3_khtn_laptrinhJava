<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit publisher</title>
</head>
<body>
<h1>Edit publisher id #${p.publisherId }</h1>
<form action="${pageContext.request.contextPath}/EditPublisherServlet" method="post" >
	<input type="text" name="id" value="${p.publisherId }" hidden="hidden" />
	<p>Name: <input type="text" name="name" value="${p.publisherName }" /></p>
	<p><input type="submit" name="btnName" value="save" /></p>
</form>
</body>
</html>