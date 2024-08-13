<%--1 trang khi gọi đến sẽ mở upload file - sau đó hiển thị form, sau đó người ta chọn tập tin để hiển thị trên web server --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload file</title>
</head>
<body>
	<%--Method ta đặt là post vì post sẽ ko giới hạn thông tin truyền đi trên thanh địa chỉ --%>
	<form action="UploadServlet" method="post"
		enctype="multipart/form-data">
		<p>
			Tập tin: <input type="file" name="tapTin" />
		</p>
		<p>
			<input type="submit" name="btnUpload" value="Upload" />
		</p>
	</form>
	<%-- <%if(request.getAttribute("tt")!=null){ %> 
	<p><img src="uploads/<%=request.getAttribute("tt") %>" /></p>
<%} %>--%>
	<c:if test="${not empty tt }">
		<img alt=" " src="uploads/${tt }">
	</c:if>
</body>
</html>