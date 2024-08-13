package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import javaBeans.SanPham;

public class SanPhamBL {
	public static SanPham docTheoId(int idSanPham) {
		String sql = "SELECT * FROM sanpham WHERE id=" + idSanPham;
		List<SanPham> dssp = taoDanhSach(sql);
		if (dssp.size() > 0) {
			return dssp.get(0);
		} else {
			return null;
		}
	}

	public static List<SanPham> taoDanhSach(String sql) {
		List<SanPham> dssp = null;
		try (Connection ketNoi = CSDL.getConnection()) {
			Statement stm = ketNoi.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dssp = new ArrayList<SanPham>();
			while (rs.next()) {
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
		} catch (Exception e) {
			throw new RuntimeException("Bi loi" + e.getMessage());
		}
		return dssp;
	}
	public static List<SanPham> laySanPhamMoi(int top) {
		
		List<SanPham> dssp = new ArrayList<SanPham>();
		String sql = "SELECT * FROM `sanpham` ORDER BY ngaytao DESC LIMIT 0," + top;
		dssp = taoDanhSach(sql);
		return dssp;
	}

	public static List<SanPham> docTatCa() {
		List<SanPham> dssp = new ArrayList<SanPham>();
		String sql = "SELECT * FROM sanpham";
		dssp = taoDanhSach(sql);
		return dssp;
	}
	public static List<SanPham> docTheoLoai(int idLoai){
		String sql = "SELECT * FROM sanpham WHERE id_loai=" +idLoai;
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	public static List<SanPham> docTheoThuongHieu(int idThuongHieu){
		String sql = "SELECT * FROM sanpham WHERE id_thuonghieu=" +idThuongHieu;
		List<SanPham> dssp = taoDanhSach(sql);
		return dssp;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<SanPham> dssp = docTatCa();
		dssp.forEach(ds -> System.out.println(ds.getTenSanPham()));
		List<SanPham> dssp10 = laySanPhamMoi(10);
		dssp10.forEach(ds -> System.out.println(ds.getTenSanPham()));
		SanPham sp = docTheoId(10);
		if (sp != null) {
			System.out.println(sp.getTenSanPham());
		} else {
			System.out.println("khoogn cos");
		}
	}
}
