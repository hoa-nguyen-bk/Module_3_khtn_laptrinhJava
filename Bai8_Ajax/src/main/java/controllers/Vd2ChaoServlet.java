package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd2ChaoServlet
 */
@WebServlet("/Vd2ChaoServlet")
public class Vd2ChaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vd2ChaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//nghĩa là trả về cái trang này cho client
		response.sendRedirect("vd2_chao_cach2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//nhập tên rồi click vào về
		// tải lại toàn bộ trang
		//xong rồi trả về 
		request.setCharacterEncoding("UTF-8");
		String ten = request.getParameter("ten");
		String loiChao = "Chào mừng bạn " + ten + " đến với ajax";
		request.setAttribute("ten", ten);
		request.setAttribute("loiChao", loiChao);
		request.getRequestDispatcher("vd2_chao_cach2.jsp").forward(request, response);
	}

}
