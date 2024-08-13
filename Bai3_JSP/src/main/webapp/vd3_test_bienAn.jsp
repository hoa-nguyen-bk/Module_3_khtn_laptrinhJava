<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minh họa phạm vi/tầm vực của biến ẩn</title>
</head>
<body>
<!-- đây là biến mức toàn cục nên nó vẫn nhìn thấy -->
<p><%= application.getAttribute("donVi") %> </p>

<!-- khi đóng trang rồi mở lại, hoặc dùng lệnh xóa session nó sẽ hiển thị lại-->
<p><%= session.getAttribute("tenND") %> </p>
<p><%= request.getAttribute("yeuCau") %> </p>
<p><%= pageContext.getAttribute("trang") %> </p>

</body>
</html>