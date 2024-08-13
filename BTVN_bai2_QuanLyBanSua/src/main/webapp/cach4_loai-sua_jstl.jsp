<%@page import="javaBean.LoaiSua"%>
<%@page import="java.util.List"%>
<%@page import="businessLogic.LoaiSuaBL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="businessLogic.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sữa cách 4</title>
</head>
<body>
	<table border="1">
		<caption>Danh sách loại sữa</caption>
		<tr>
			<th>Mã loại</th>
			<th>Tên loại</th>
		</tr>
		<c:forEach items="${dsls }" var="ls">
		<tr>
			<td>${ls.getMaLoai()}</td>
			<td>${ls.getTenLoai()}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>