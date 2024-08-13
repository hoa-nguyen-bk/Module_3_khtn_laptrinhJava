package businessLogics;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.LoaiSua;

/**
 * Servlet implementation class LoaiSuaBL_cach4
 */
@WebServlet("/LoaiSuaBL_cach4")
public class LoaiSuaBL_cach4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiSuaBL_cach4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Chỗ này giúp tái sử dụng nhìu lần, giống bên oop
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		request.setAttribute("dsls", dsls);
		request.getRequestDispatcher("cach4_loai-sua_jstl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
