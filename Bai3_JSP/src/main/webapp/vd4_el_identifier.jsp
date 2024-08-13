<%@page import="javaBean.LoaiSua"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minh họa EL</title>
<%
	// 1. biến đơn
	int a = 5;
	request.setAttribute("a", a);
	
	// 2. Biến mảng
	int[] b = {1,5,2,6,4};
	pageContext.setAttribute("b", b);

	// 3. List
	List<String> ds = Arrays.asList("mai","lam","cuc","truc");
	application.setAttribute("ds", ds);
	
	// 4.map
	Map<String,String> td = new TreeMap<String,String>();
	td.put("one", "một");
	td.put("two", "hai");
	td.put("one2", "một4");
	session.setAttribute("td", td);
	
	//5. java bean
	LoaiSua ls = new LoaiSua();
	ls.setMaLoai("AA");
	ls.setTenLoai("Sữa AA");
	request.setAttribute("ls", ls);
%>
</head>
<body>
<p>a = <%=a %></p>
<p>a = ${a}</p>

<p>b[2] = <%=b[2] %></p>
<p>a = ${b[2]}</p>

<p>
ds[1] <%=ds.get(1) %> 
</p>

<p> ds[1] = ${ds[1]} </p>

<p>td["2"] = <%=td.get("two") %></p>
<p>td["2"] = ${td["two"] }</p>

<p>Mã loại: <%=ls.getMaLoai() %>; Tên loại: <%=ls.getTenLoai() %></p>
<p>Mã loại: ${ls.maLoai }; Tên loại: ${ls.tenLoai }</p>

<!-- http://localhost:8080/Bai3_JSP/vd4_el_identifier.jsp?ten=iu_lam -->
<p>Tên: <%=request.getParameter("ten") %></p>
<p>Tên: ${param.ten }</p>

</body>
</html>