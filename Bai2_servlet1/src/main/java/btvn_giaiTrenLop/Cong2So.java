package btvn_giaiTrenLop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cong2So
 */
@WebServlet("/Cong2So")
public class Cong2So extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cong2So() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8'>");
		pw.println("<title>Cộng 2 số</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>Cộng 2 số</h1>");
		pw.println("<form method='post'>");
		pw.println("<label>Số a:</label></br><input type='text' name='soA'/></br>");
		pw.println("<label>Số b:</label></br><input type='text' name='soB'/></br>");
		pw.println("<input type='submit' name='btSum' value='Sum'>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
