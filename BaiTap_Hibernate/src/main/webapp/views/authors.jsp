<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
</head>
<body>
	<h1>Manage Author</h1>
	<a href="AddAuthorServlet">
		<button>Add author</button>
	</a>
	<form action="" method="post">
		<table id="table-author" border="1">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Edit</th>
					<th>Del</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors }" var="at">
					<tr>
						<td>${at.authorId }</td>
						<td>${at.authorName }</td>
						<td><a href="EditAuthorServlet?id=${at.authorId }"> <img
								alt="edit" src="img/edit.png">
						</a></td>
						<td><a href="DelAuthorServlet?id=${at.authorId }"> <img
								alt="del" src="img/trash.png">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

</body>
</html>