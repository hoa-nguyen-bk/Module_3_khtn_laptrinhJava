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
<title>Bài tập 3</title>
<!-- thẻ biến -->
<%!Connection con = CSDL.getCon();
	Statement stm;
	ResultSet rs = null;
	String sql = "select s.Ten_sua, h.Ten_hang_sua, l.Ten_loai, s.Trong_luong, s.Don_gia from sua s "
			+ "inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua "
			+ "inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua";
	Locale lc = new Locale("vi", "VN");
	NumberFormat nf = NumberFormat.getNumberInstance(lc);
	int soDongMoiTrag = 5, tongSoTrang = 0, trang = 1;
%>
<%
stm = con.createStatement();
if (rs == null) {
	rs = stm.executeQuery(sql);
	rs.last();
	int tongSoDong = rs.getRow();
	tongSoTrang = tongSoDong / soDongMoiTrag + (tongSoDong % soDongMoiTrag != 0 ? 1 : 0);

}
if (request.getParameter("trang") != null) {
	trang = Integer.parseInt(request.getParameter("trang"));

}
int viTri = (trang - 1) * soDongMoiTrag;
rs = stm.executeQuery(sql + " limit " + viTri + "," + soDongMoiTrag);
int stt = viTri+1;
%>
</head>
<body>
<table border="1">
	<caption>Thông tin sữa</caption>
	<tr>
		<th>Stt</th>
		<th>Tên sữa</th>
		<th>Hãng sữa</th>
		<th>Loại sữa</th>
		<th>Trọng lượng</th>
		<th>Đơn giá</th>
	</tr>
	<%while(rs.next()){ %>
	<tr>
		<td><%=stt++ %></td>
		<td><%=rs.getString("ten_sua") %></td>
		<td><%=rs.getString("ten_hang_sua") %></td>
		<td><%=rs.getString("ten_loai") %></td>
		<td><%=rs.getInt("trong_luong") %> g</td>
		<td><%=nf.format(rs.getInt("don_gia")) %> VND</td>
	</tr>
	<%} %>
</table>
<p>
<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=1">&lt;&lt;</a>
<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=<%=trang-1<1?1:trang-1 %>">&lt;</a>
<%for(int i = 1;i<=tongSoTrang;i++){ %>
	<%if(trang==i){ %>
		<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=<%=i %>" style="color:red;font-weight:bold"><%=i %></a>
	<%} else { %>
		<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=<%=i %>"><%=i %></a>
	<%} %>
<%} %>
<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=<%=trang+1>tongSoTrang?tongSoTrang:trang+1 %>">&gt;</a>
<a href="thong-tin-sua_phantrang_bienAn.jsp?trang=<%=tongSoTrang %>">&gt;&gt;</a>
</p>
</body>
</html>