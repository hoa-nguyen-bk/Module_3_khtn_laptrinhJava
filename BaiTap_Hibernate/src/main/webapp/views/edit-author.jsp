<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit author</title>
</head>
<body>
<h1>Edit author #</h1>
<form id="edit-author" method="post" action="${pageContext.request.contextPath }/EditAuthorServlet" >
	<input type="text" name="id" value="${at.authorId }" hidden="hidden" />
	<p><label>Name: </label> <input type="text" name="name" value="${at.authorName }"/> </p>
	</br>
	<input type="submit" name="btnSave" value="Save" /> 
</form>
</body>
</html>