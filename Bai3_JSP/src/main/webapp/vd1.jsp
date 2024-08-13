<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
	int a = 1;
	int cong(int x,int y){
		return x+y;
	}
%>
<%
	int b = 2;
	int tong = cong(a,b);
%>
</head>
<body>
<h1>Tính tổng nè</h1>
<p> Tổng: <%= a %>+<%= b %>=<%= tong %>
</p>
<jsp:include page="chao.jsp"/>
<%--ví dụ về sử dụng 6 jsp tag --%>
</body>
</html>