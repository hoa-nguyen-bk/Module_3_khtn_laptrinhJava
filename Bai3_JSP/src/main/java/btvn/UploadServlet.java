package btvn;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("btvn_3_4_upload-file.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part part = request.getPart("tapTin");
		String tt, tm;
		tm = getServletContext().getRealPath("/uploads/");
		
		// lấy tên tập tin
		tt = part.getSubmittedFileName();
		InputStream is = part.getInputStream();
		//cách 1: dùng stream bình thường
//		OutputStream os = new FileOutputStream(tm + tt);
		//cách 2 dùng buffer
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(tm+tt));
		
		// Cách 1: ghi file: này là đọc ghi từng byte, giờ mình đọc ghi từng khối 1
//		int b;
//		while((b=is.read())!=-1) {
//			os.write(b);
//		}
		// Cách 2 đọc 1 lần 1 cái mảng byte luôn
		byte[] mb = new byte[1024];
		int len;
		while((len=is.read(mb,0,1024))>0) {
			//Writes b.length bytes from the specified byte arrayto this output stream:
			//ghi theo chiều dài từ vị trí 0 của mảng
//		lần đầu tiên đọc mảng này từ vị trí 0 tới 1024 byte, và len trả về 1024, lần thứ 2 while lên đọc típ 1024 nhưng hiện giờ còn có 6 byte
			os.write(mb,0,len);
		}
		//đóng file
		is.close();
		os.close();
		
		//giờ mình muốn quay trở về lại để cho người ta tải tiếp thì mình sẽ dùng get
//		doGet(request, response);
		
		request.setAttribute("tt", tt);
		request.getRequestDispatcher("btvn_3_4_upload-file.jsp").forward(request, response);
		
		//mình mún biết thư mục ngầm định của uploads/ này nằm đâu thì mình vào
//		E:\HOC\java_khtn\Module_3\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Bai3_JSP\loads
		//bật server -> open F3-> open launch configuration -> argument -> xem -Dwtp.deploy= chính là khứa ở trên
		
		
	}
}
