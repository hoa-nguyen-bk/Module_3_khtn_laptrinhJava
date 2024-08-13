<%-- 
    Document   : san-pham-moi
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="maincontent-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="latest-product">
					<h2 class="section-title">New Products</h2>
					<div class="product-carousel">
						<c:forEach items="${dssp }" var="sp">

							<div class="single-product">
								<div class="product-f-image">
									<img src="img/${sp.hinhAnh }" alt="">
									<div class="product-hover">
									<%--truyền idsp là sp.id và số lượng mua là 1 --%>
										<a href="ThemVaoGioServlet?idsp=${sp.id }?slm=1" class="add-to-cart-link"><i
											class="fa fa-shopping-cart"></i> Thêm vào giỏ</a> <a
											href="single-product.html" class="view-details-link"><i
											class="fa fa-link"></i> Xem chi tiết</a>
									</div>
								</div>

								<h2>
									<a href="single-product.html">${sp.tenSanPham }</a>
								</h2>

								<div class="product-carousel-price">
									<ins>$${sp.donGiaKM }</ins>
									<del>$${sp.donGia }</del>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End main content area -->
