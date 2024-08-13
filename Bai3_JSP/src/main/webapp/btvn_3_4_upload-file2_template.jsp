<%--1 trang khi gọi đến sẽ mở upload file - sau đó hiển thị form, sau đó người ta chọn tập tin để hiển thị trên web server --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<tags:btvn_3_6_template tieuDe="Upload file">
	<jsp:attribute name="noiDung">
	<h1>Minh họa tải tập tin lên web server</h1>
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
	<c:if test="${not empty tt }">
		<img alt=" " src="uploads/${tt }">
	</c:if>
	</jsp:attribute>
</tags:btvn_3_6_template>