package btvn_giaiTrenLop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cong2SoHtml
 */
@WebServlet("/Cong2SoHtml")
public class Cong2SoHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cong2SoHtml() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cách 1: chuyển tiếp qua html luôn
//		response.sendRedirect("cong-2-so.html");
//		cách 2: chỉ gửi iu cầu qua trang html chứ hiện tại vẫn ở trang servlet
		if(request.getParameter("btnSum")==null)
			request.getRequestDispatcher("cong-2-so.html").forward(request, response);
		else
			doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8'>");
		pw.println("<title>Kết quả</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>Kết quả cộng 2 số</h1>");
		double a =Double.parseDouble(request.getParameter("soA"));
		double b =Double.parseDouble(request.getParameter("soB"));
		pw.println("<h2>"+String.format("Sum %.2f + %.2f = %.2f", a,b,a+b)+"</h2>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
