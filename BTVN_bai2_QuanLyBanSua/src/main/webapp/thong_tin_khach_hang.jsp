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
<title>Thông tin khách hàng</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&family=Roboto+Mono:ital,wght@0,100..700;1,100..700&display=swap"
	rel="stylesheet">
<%--<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet"> --%>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/nes.css/2.3.0/css/nes.min.css"
	rel="stylesheet">

<%!Connection con = CSDL.getCon();
	Statement stm;
	ResultSet rs;
	String sql = "SELECT * FROM khach_hang";%>
<%
stm = con.createStatement();
rs = stm.executeQuery(sql);
%>
<link rel="stylesheet" href="css/style.css">
<style>
.roboto-mono {
	font-family: "Roboto Mono", monospace;
	font-optical-sizing: auto;
	font-weight: <weight>;
	font-style: normal;
}

html, body, pre, code, kbd, samp {
	font-family: "Roboto Mono";
}

.nes-field.is-inline {
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<div style="margin: 50px auto; width: 90%">
		<div class="nes-container  with-title">
			<p class="title">Thông tin khách hàng</p>

			<table border="1">
				<tr>
					<th>Mã KH</th>
					<th>Tên khách hàng</th>
					<th>Giới tính</th>
					<th>Địa chỉ</th>
					<th>Số điện thoại</th>
					<th>Email</th>
					<th><img src="img/but_sua.png" alt="" /></th>
					<th><img src="img/but_xoa.png" alt="" /></th>
				</tr>
				<%
				while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getString("ma_khach_hang")%></td>
					<td><%=rs.getString("ten_khach_hang")%></td>
					<td><img
						src="img/<%=rs.getBoolean("phai") ? "nu" : "nam"%>.jpg" alt="" /></td>
					<td><%=rs.getString("dia_chi")%></td>
					<td><%=rs.getString("dien_thoai")%></td>
					<td><%=rs.getString("email")%></td>
					<td><button id="edit" name="btnEdit">Sửa</button></td>
					<td><button id="delete" name="btnDelete">Xóa</button></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		<br />
		<form method="post" class="form">
			<div id="search_form" class="nes-container with-title">
				<p class="title">Cập nhập thông tin khách hàng</p>

				<div class="nes-field is-inline">
					<label>Mã khách hàng</label> <input type="text" class="nes-input">
				</div>
				<div class="nes-field is-inline">
					<label>Tên khách hàng</label> <input type="text" class="nes-input">
				</div>
				<div class="nes-field">
					<label>Giới tính</label> <label> <input type="radio"
						class="nes-radio" name="answer" checked /> <span>Nữ</span>
					</label> <label> <input type="radio" class="nes-radio"
						name="answer" /> <span>Nam</span>
					</label>

				</div>
				<div class="nes-field is-inline">
					<label>Địa chỉ</label> <input type="text" class="nes-input">
				</div>
				<div class="nes-field is-inline">
					<label>Điện thoại</label> <input type="text" class="nes-input">
				</div>
				<div class="nes-field is-inline">
					<label>Email</label> <input type="text" class="nes-input">
				</div>
				<div class="nes-field is-inline">
					<button type="submit" class="nes-btn  is-primary">Cập nhập</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>