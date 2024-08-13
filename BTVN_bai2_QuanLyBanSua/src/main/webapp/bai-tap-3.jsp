<!-- thẻ chỉ thị -->
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
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
<title>Thông tin các sản phẩm</title>
<!-- thẻ biến -->
<%!Connection con = CSDL.getCon();
	Statement stm;
	ResultSet rs;
	String sql = "select s.Ten_sua, h.Ten_hang_sua, l.Ten_loai, s.Trong_luong, s.Don_gia, s.Hinh from sua s "
			+ "inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua "
			+ "inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua";
	Locale lc = new Locale("vi","VN");
	NumberFormat nf = NumberFormat.getNumberInstance(lc);
			%>
<%
stm = con.createStatement();
rs = stm.executeQuery(sql);
%>
<style type="text/css">
img {
	width: 100px;
	height: 100px;
	    object-fit: contain;
}

table {
	margin: auto;
}

th {
	background-color: khaki;
	font-size: 25px;
	font-weight: bold;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">Thông tin các sản phẩm</th>

		</tr>
		<% while(rs.next()){ %>
		<tr>
			<td><img alt="abc" src="img/<%=rs.getString("hinh") %>"></td>
			<td><%= rs.getString("ten_sua") %> <br>
			<br> Nhà sản xuất: <%= rs.getString("ten_hang_sua") %><br>
				<%= rs.getString("ten_loai") %> - <%=rs.getString("trong_luong") %> - <%= nf.format(rs.getInt("don_gia")) %> VND
			</td>
		</tr>

		<% }%>

	</table>
</body>
</html>