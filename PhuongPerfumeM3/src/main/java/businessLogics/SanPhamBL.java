package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.SanPham;

public class SanPhamBL {
	public static List<SanPham> docTatCa(int top){
		List<SanPham> dssp = new ArrayList<SanPham>();
		String sql = "SELECT * FROM `sanpham` ORDER BY ngaytao DESC LIMIT 0,"+top;
		try (Connection con = CSDL.getConnection()){
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery(sql);
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setIdThuongHieu(rs.getInt("id_thuonghieu"));
				sp.setIdLoai(rs.getInt("id_loai"));
				sp.setHienThi(rs.getInt("hienthi"));
				sp.setNgayTao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setMoTa(rs.getString("mota"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				sp.setId(rs.getInt("id"));
				dssp.add(sp);
			}
			return dssp;
		} catch (Exception e) {
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<SanPham> dssp = docTatCa(10);
		dssp.forEach(ds -> System.out.println(ds.getTenSanPham()));
	}
}
