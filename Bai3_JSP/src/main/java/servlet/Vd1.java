package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd1
 */
@WebServlet("/Vd1")
public class Vd1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int a = 1;
	private int cong(int x, int y) {
		return x+y;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vd1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b = 2;
		int tong = cong(a,b);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8'>");
		pw.println("<title>Minh họa JSP tag</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<p> Rất đẹp là "+String.format("%d + %d = %d", a,b,tong)+"</p>");
		//còn phần inclue thì
		request.getRequestDispatcher("chao.jsp").include(request, response);
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
