<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minh họa các biến ẩn</title>
<%
//application, 
application.setAttribute("donVi", "Trung tâm tin học");
//session: 
session.setAttribute("tenND", "Trần thị hòa minzy xinh đẹp");
// có thể đặt lại iu cầu of trang
request.setAttribute("yeuCau", "Minh họa các biến ẩn trong JSP");
//ngữ cảnh của trang
pageContext.setAttribute("trang", "vd2.jsp");
//trong cái môi trường hiện tại của trang có thể lấy đối tượng thông qua cái này
//pageContext.getRequest đồ cũng ko cần nữa, vì bên trên có gọi request. đồ rồi 
%>
</head>
<body>
<p><%= application.getAttribute("donVi") %> </p>
<p><%= session.getAttribute("tenND") %> </p>
<p><%= request.getAttribute("yeuCau") %> </p>
<p><%= pageContext.getAttribute("trang") %> </p>

</body>
</html>