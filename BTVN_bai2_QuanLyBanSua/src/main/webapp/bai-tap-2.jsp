<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="businessLogic.CSDL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
<%!
	Connection con = CSDL.getCon();
	Statement stm;
	ResultSet rs;
	String sql = "select * from khach_hang";

%>

<%
stm = con.createStatement();
rs = stm.executeQuery(sql);
%>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<table border="1">
		<caption>Thông tin khách hàng</caption>
		<tr>
			<th>Mã khách hàng</th>
			<th>Tên khách hàng</th>
			<th>Giới tính</th>
			<th>Địa chỉ</th>
			<th>Điện thoại</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<%--chỗ này có thể gõ thoải mái chút, ko cần gõ đúng như nó muốn --%>
			<td><%=rs.getString("ma_khach_hang")%></td>
			<td><%=rs.getString("ten_khach_hang")%></td>
			<td><img
				src="img/<%=rs.getBoolean("phai") ? "nu.jpg" : "nam.jpg"%>" /></td>
			<td><%=rs.getString("dia_chi")%></td>
			<td><%=rs.getString("dien_thoai")%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>