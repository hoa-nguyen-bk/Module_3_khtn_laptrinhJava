package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.SuaBL;
import entities.Sua;

/**
 * Servlet implementation class SuaServlet
 */
@WebServlet("/TimSuaServlet")
public class TimSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimSuaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<Sua> dssua = SuaBL.docTatCa();
		request.setAttribute("dssua", dssua);
		request.getRequestDispatcher("timsua.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten;
		ten = request.getParameter("txttenSua");
		List<Sua> ls = SuaBL.docTheoMaHangLoaiTen("", "",ten);
		HttpSession session = request.getSession();
		session.setAttribute("dssua", ls);
		session.setAttribute("ten", ten);
		response.sendRedirect("timsua.jsp");
	}

}
