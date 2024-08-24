<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<title>Chào</title>
</head>
<body>
	<form action="Vd2ChaoServlet" id="form-1" method="post">
		<p>
			<label for="input-1">Nhập tên:</label> <input id="input-1"
				placeholder="Text" name="ten" value="${ten }" type="text" />
		</p>
		<p>
			<input id="input-2" placeholder="Text" type="text" name="loiChao"
				value="${loiChao }" style="width: 300px" />
		</p>
		<p>
			<input type="submit" name="btn" value="Xuất lời chào">
		</p>
	</form>
</body>
</html>