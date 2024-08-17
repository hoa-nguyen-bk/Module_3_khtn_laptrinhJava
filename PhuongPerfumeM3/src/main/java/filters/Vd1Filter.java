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

/**
 * Servlet Filter implementation class Vd1Filter
 */
@WebFilter("/Vd1Filter")
public class Vd1Filter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter() khởi tạo
     */
    public Vd1Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy() phá hủy
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// HttpServletRequest không còn mà là ServletRequest
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// và in ra phía sau
		System.out.println("uri"+uri);
		
		//lấy mỗi cái trang thôi, bỏ dấu / đi tức là + 1
		String trang = uri.substring(uri.lastIndexOf('/')+1);
		System.out.println(trang);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
