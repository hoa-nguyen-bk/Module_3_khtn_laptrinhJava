<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="businessLogic.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại sữa</title>
<%!Connection con = CSDL.getCon();
	Statement stm;
	ResultSet rs;
	String sql = "select * from loai_sua";%>
	
<% 
	stm = con.createStatement();
	rs=stm.executeQuery(sql);
%>
</head>
<body>
	<table border="1">
		<caption>Danh sách loại sữa</caption>
		<tr>
			<th>Mã loại</th>
			<th>Tên loại</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%= rs.getString("ma_loai_sua") %></td>
			<td><%= rs.getString("ten_loai") %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>