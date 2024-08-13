<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cộng 2 số</title>
<%
//tức là lần đầu nó chưa có gì, thì dĩ nhiên btnCong = null, lúc đó thì ko chạy gì hết, đến khi nó khác null là nó chạy cái gì đó	
String a = "", b = "", kq = "";
if (request.getParameter("btnCong") != null) {
	a = request.getParameter("soA");
	b = request.getParameter("soB");
	int k = Integer.parseInt(a) + Integer.parseInt(b);
	kq = String.valueOf(k);
}
%>
</head>
<body>
	<!-- khi ta ko chỉ trang nào hết, thì nó sẽ tự gọi chính trang này trên server -->
	<form action="" method="post">
		<p>
			<label>Số a: </label><input type="text" name="soA" value="<%=a%>">
		</p>
		<p>
			<label>Số b: </label><input type="text" name="soB" value="<%=b%>">
		</p>
		<p>
			<input type="submit" name="btnCong" value="Cộng">
		</p>
		<p>
			<label>Kết quả: </label><input type="text" name="kq" value="<%=kq%>">
		</p>

	</form>
</body>
</html>