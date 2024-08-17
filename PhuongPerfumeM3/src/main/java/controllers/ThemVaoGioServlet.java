package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogics.GioHang;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet("/ThemVaoGioServlet")
public class ThemVaoGioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemVaoGioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dựa vào cái tham số truyền vào
		int idSanPham, soLuongMua;
		idSanPham = Integer.parseInt(request.getParameter("idsp"));
		soLuongMua = Integer.parseInt(request.getParameter("slm"));
		HttpSession session = request.getSession();
		GioHang gioHang = (GioHang) session.getAttribute("gioHang");
		if (gioHang == null) {
			gioHang = new GioHang();
			session.setAttribute("gioHang", gioHang);
		}
		gioHang.them(idSanPham, soLuongMua);
		// sau khi thêm xong thì quay về trang chủ
		response.sendRedirect("trang-chu.jsp");
		// khi quay về trang chủ thì phải hiển thị họ tên người đăng nhập, tổng hàng và
		// tổng tiến
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
