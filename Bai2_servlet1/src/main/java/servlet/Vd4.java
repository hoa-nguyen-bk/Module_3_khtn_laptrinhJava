package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd4
 */
@WebServlet(
		description = "zvis dụ 4 về servlet", 
		urlPatterns = { 
				"/Vd4", 
				"/vd4.html",
				"/vd4.htm"
		}, 
		initParams = { 
				@WebInitParam(name = "a", value = "1"), 
				@WebInitParam(name = "b", value = "2")
		})
public class Vd4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vd4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//3 looại tham số: tham số initial Params, tham số truyền theo địa chỉ, 
		ServletConfig scg = getServletConfig();
		String a = scg.getInitParameter("a");
		ServletContext sct = getServletContext();
		String donVi = sct.getInitParameter("donVi");
		response.getWriter().println("Don vi= "+donVi);
		response.getWriter().print("a = "+a);

		response.getWriter().println("xx = "+request.getParameter("xx"));
		String url = request.getRequestURI();
		response.getWriter().println("url = "+url);
		
		String serverName = request.getServerName();
		response.getWriter().println("Server name = "+serverName);
		response.getWriter().print("bien 1 = "+request.getAttribute("bien1"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
