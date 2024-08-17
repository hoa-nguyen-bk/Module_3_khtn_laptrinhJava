
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Publisher</title>
</head>
<body>
	<h1>Manager Publisher</h1>
	<p>
		<a href="AddPublisherServlet">Add new Publisher</a>
	</p>
	<form action="DeletePublisherServlet" method="post">

		<table border="1">

			<tr>
				<th><input type="submit" name="btnDelete" value="Delete" /></th>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Del</th>
			</tr>
			<c:forEach items="${publishers }" var="p">
				<tr>
					<td><input type="checkbox" name="idXoa"
						value="${p.publisherId }" /></td>
					<td>${p.publisherId }</td>
					<td>${p.publisherName }</td>
					<td><a href="EditPublisherServlet?id=${p.publisherId }"><img
							alt="edit" src="img/edit.png"> </a></td>
					<td><a href="DelPublisherServlet?id=${p.publisherId }"><img
							alt="edit" src="img/trash.png"> </a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>