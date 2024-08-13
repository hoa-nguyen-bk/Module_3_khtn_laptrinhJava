<%-- 
    Document   : trang-chu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="views/dau-trang.jsp"/>
<jsp:include page="views/chinh-sach.jsp"/>
<%-- vì mình gọi trang views/quang-cao.jsp thì nó ko gọi được db, vậy nên ta cần gọi tới Servlet, cái này liên quan tới cấu hình để kiểm tra ràng buộc thôi, thành ra mình sẽ tắt cái này đi --%>
<jsp:include page="QuangCaoServlet"/>
<jsp:include page="SanPhamMoiServlet"/>
<jsp:include page="ThuongHieuServlet"/>
<jsp:include page="views/ban-chay-yeu-thich.jsp"/>
<jsp:include page="views/cuoi-trang.jsp"/>
