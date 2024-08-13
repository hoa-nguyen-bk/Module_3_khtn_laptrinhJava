<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minh họa JSTL</title>
</head>
<body>

	<%
	//double so = 123.567;
	//pageContext.setAttribute("so", so);
	%>
	<c:set value="123.455" var="so" />
	<p>Số (Java): ${so}</p>
	<fmt:setLocale value="vi-VN" />
	<fmt:formatNumber value="${so}" var="soVn" />
	<p>Số (VN): ${soVn}</p>

	<c:if test="${so>123.0 }">
		<p>Số lớn hơn 123</p>
	</c:if>
	<c:set value="Trung tâm tin học" var="t3h" />
	<h1>
		<c:out value="${t3h }" />
	</h1>
	<p>Chiều dài chuỗi: ${fn:length(t3h) }</p>
</body>
</html>