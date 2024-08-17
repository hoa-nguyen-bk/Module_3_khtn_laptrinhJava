<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add new publisher</title>
</head>
<body>
	<h1>Add new publisher</h1>
	<%--Chỗ này là thêm đường dẫn tuyệt đối  pageContext.request.contextPath--%>
	<form action="${pageContext.request.contextPath}/AddPublisherServlet" method="post">
		<p>
			Name:<input type="text" name="name" />
		</p>
		<input name="btnSave" type="submit" value="Save">
	</form>
</body>
</html>