package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Vd3Servlet_minh2")
public class Vd3Servlet_minh2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Vd3Servlet_minh2() {
        super();
    }
    //http://localhost:8080/Bai2/Vd1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Viết ở đây
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='UTF-8'>");
		pw.println("<title>Ví dụ 2</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<table border='1'>");
		pw.println("<caption>DANH SÁCH LOẠI SỮA</caption>");
		pw.println("<tr>");
		pw.println("<th>Mã loại</th>");
		pw.println("<th>Tên loại</td>");
		pw.println("</tr>");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3309/ql_bansua?useUnicode=true&characterEncoding=UTF-8";
			Connection kn = DriverManager.getConnection(url,"root","");
			
			Statement stm = kn.createStatement();
			String sql = "select * from loai_sua";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getString("ma_loai_sua")+"</td>");
				pw.println("<td>"+rs.getString("ten_loai")+"</td>");
				pw.println("</tr>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
