package btvn;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumTwoNumbers
 */
@WebServlet("/SumTwoNumbers")
public class Bai2_SumTwoNumbers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bai2_SumTwoNumbers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter pw = response.getWriter()){
			pw.write("<form method=\"post\">");
			pw.write("<p>");
				pw.write("<label>Number a</label>");
				pw.write("<input type=\"number\" name=\"a\">");
			pw.write("</p>");
			pw.write("<p>");
				pw.write("<label>Number b</label>");
				pw.write("<input type=\"number\" name=\"b\">");
			pw.write("</p>");
			pw.write("<button type=\"submit\">submit</button>");
			pw.write("</form>");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		try (PrintWriter pw=response.getWriter()){
			pw.printf("<p>Sum %d + %d = %d</p>", a,b,a+b);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

}
