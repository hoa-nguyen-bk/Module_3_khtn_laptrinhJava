<%@ tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true" %>

<%-- 
trong thư mục web-infomation nó chứa thư viện và thư mục xml, nó chứa lib và các lớp, thẻ thư viện
Bước 1: tạo thư mục tên là tags -> new JSP file -> đặt tên phần mở rộng là <gì cũng được>.tag
Bước 2: Gõ cái html:5 trước rồi mới gõ 3 dòng trên sau --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet"  type="text/css" ref="${pageContext.request.contextPath }/css/css.css"  >
</head>
<body>
<div class="title">
	<div class="container">
		<div class="brand">
			<a href="${pageContext.request.contextPath }">
				MODULE 3: lập trình jsp servlet
			</a>
			
		</div>
	</div>
</div>
<div class="sidebar">
	<ul>
		<li><a href="#">Trang chủ</a></li>
		<li><a href="cach4_loai-sua_jstl.jsp">Loại sữa</a></li>
		<li><a href="sendmail.jsp">Gửi mail</a></li>
		<li><a href="#">Trang chủ</a></li>
		<li><a href="#">Trang chủ</a></li>
		
	</ul>
</div>
<div class="main">
	<jsp:invoke fragment="content"/>
</div>
</body>
</html>