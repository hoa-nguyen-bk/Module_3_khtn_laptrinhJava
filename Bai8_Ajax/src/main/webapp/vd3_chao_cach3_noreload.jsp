<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ 3</title>
<script  src="js/vd3.js"></script>
</head>
<body>
<form action="Vd2ChaoServlet" id="form-1" method="post">
		<p>
			<label for="input-1">Nhập tên:</label> <input id="ten"
				placeholder="Text"  value="" type="text" />
		</p>
		<p>
			<input id="loiChao" placeholder="Text" type="text" 
				value="" style="width: 300px" />
		</p>
		<p>
			<button onclick="xuatLoiChao()" name="btn" >Xuất lời chào</button>
		</p>
	</form>
</body>
</html>