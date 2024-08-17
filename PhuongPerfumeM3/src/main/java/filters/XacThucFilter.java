package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaBeans.NguoiDung;

/**
 * Servlet Filter implementation class XacThucFilter
 */
@WebFilter("/XacThucFilter")
public class XacThucFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public XacThucFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Nếu mình có 1 biến bao hàm lớp thì mình nên làm ép kiểu, ví dụ mình đưa vào 1
		// tham số, dòng họ lê chẳng hạn
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// giờ mình lấy địa chỉ để mình lấy được cái trang
		String uri = req.getRequestURI();

		NguoiDung nd = (NguoiDung) session.getAttribute("nd");
		// từ đây mình lấy ra cái trang
		String trang = uri.substring(uri.lastIndexOf('/') + 1);
		// Nếu người dùng chưa đăng nhập (nd==null) tu thì đưa zề đâu
		if (nd == null && trang.equals("trang-gio-hang.jsp")) {
			res.sendRedirect("trang-chu.jsp");
		} else {

			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
