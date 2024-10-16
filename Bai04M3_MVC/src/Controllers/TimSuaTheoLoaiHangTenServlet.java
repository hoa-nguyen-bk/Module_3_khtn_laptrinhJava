package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.HangSuaBL;
import BusinessLogics.LoaiSuaBL;
import BusinessLogics.SuaBL;
import JavaBeans.HangSua;
import JavaBeans.LoaiSua;
import JavaBeans.Sua;

@WebServlet({ "/TimSuaTheoLoaiHangTenServlet", "/tim-sua.htm" })
public class TimSuaTheoLoaiHangTenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimSuaTheoLoaiHangTenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String maLoai, maHang, tenSua;
        
        maLoai=request.getParameter("cboLoai");
        maHang = request.getParameter("cboHang");
        tenSua = request.getParameter("txtTenSuaTim");
        
        List<LoaiSua> dsls = LoaiSuaBL.DocTatCa();
        List<HangSua> dshs = HangSuaBL.DocTatCa();
        List<Sua> dsSua = SuaBL.TimTheoLoaiHangTen(maLoai,maHang,tenSua);
        HangSua hangSua = HangSuaBL.DocTheoMaHang(maHang);
        
        request.setAttribute("dsls", dsls);
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsSua", dsSua);
        request.setAttribute("soSP", dsSua.size());
        request.setAttribute("hangSua", hangSua);
        
        request.getRequestDispatcher("Views/tim-sua-theo-loai-hang-ten-2.jsp").forward(request, response);
	}

}
