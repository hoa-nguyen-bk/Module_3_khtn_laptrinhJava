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
<title>Tìm kiếm thông tin sữa</title>
<%!
	Connection con = CSDL.getCon();
	Statement stmHangSua, stmLoaiSua, stmSua;
	ResultSet rsHangSua, rsLoaiSua, rsSua;
	String sql = "SELECT * FROM khach_hang";
%>
<%
stmHangSua = con.createStatement();
rsHangSua = stmHangSua.executeQuery(sql);
%>
</head>
<body>

</body>
</html>