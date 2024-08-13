<%@page import="java.util.ArrayList"%>
<%@page import="javaBean.LoaiSua"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minh họa JSTL</title>
<%
List<LoaiSua> dsls = new ArrayList<>();
LoaiSua ls1 = new LoaiSua();
ls1.setMaLoai("AA");
ls1.setTenLoai("Sữa AA");

LoaiSua ls2 = new LoaiSua();
ls1.setMaLoai("BB");
ls1.setTenLoai("Sữa bb");

LoaiSua ls3 = new LoaiSua();
ls1.setMaLoai("CC");
ls1.setTenLoai("Sữa cc");

dsls.add(ls1);
dsls.add(ls2);
dsls.add(ls3);
request.setAttribute("dsls", dsls);
%>
</head>
<body>
<p>Dùng vòng lặp for lệnh Java với JSP tags</p>
<%for(int i = 0;i<3;i++){ %> <!-- trước đây ta dùng jsp trong trông nó ntn -->
	<p>Đây là dòng <%=i %></p>
<%} %>
<p>dùng vòng lặp forEach jstl</p>
<c:forEach var="i" begin="1" end="3" step="1">
	<p>đây là dòng ${i }</p>
</c:forEach>
<p>Dùng vòng lặp for với lệnh Java theo chỉ số với JSP tag</p>
<%for(int i = 0; i<dsls.size();i++){ %>
	<p>Mã loại: <%=dsls.get(i).getMaLoai() %> Tên loại: <%=dsls.get(i).getTenLoai() %></p>
<%} %>
<p>Dùng vòng lặp for với lệnh Java theo phần tử với JSP tag</p>
<%for(LoaiSua ls:dsls){ %>
	<p>Mã loại: <%=ls.getMaLoai() %> Tên loại: <%=ls.getTenLoai() %></p>
<%} %>
<p>Dùng vòng lặp forEach thẻ JSTL với EL</p>
<c:forEach items="${dsls }" var="ls">
	<p>Mã loại: ${ls.getMaLoai()  } Tên loại: ${ls.getTenLoai() } </p>
</c:forEach>


</body>
</html>