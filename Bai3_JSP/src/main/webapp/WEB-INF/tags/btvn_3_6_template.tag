<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="tieuDe" description="empty tiu de" required="true"
	type="String"%>
<%@ attribute name="noiDung" description="empty noi Dung"
	required="true" fragment="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tieuDe }</title>
<style type="text/css">
header, footer {
	width: 100%;
	height: 100px;
	background-color: lightblue;
}

main {
	display: flex;
	width: 100%;
}

nav {
	width: 20%;
	background-color: khaki;
}

article {
	width: 80%;
	background-color: lightyellow;
}
</style>
</head>
<body>
	<header>
		<h1>Header</h1>
	</header>
	<main>
		<nav>
			<h2>Thực đơn</h2>
			<ul>
				<li><a href="chao.jsp">Chào</a></li>
				<li><a href="btvn_3_4_upload-file">Upload</a></li>
				<li><a href="#">Cộng 2 số</a></li>
				<li><a href="#">Link 4</a></li>

			</ul>
		</nav>
		<article>
			<h2>Nội dung</h2>
			<jsp:invoke fragment="noiDung" />
		</article>
	</main>
	<footer>
	<h1>Footer</h1>
	</footer>
</body>
</html>