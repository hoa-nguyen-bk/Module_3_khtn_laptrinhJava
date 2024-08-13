package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javaBeans.NguoiDung;

public class NguoiDungBL {
	public static NguoiDung timNguoiDung(String email, String pass) {
		NguoiDung nd = null;
		String sql = "SELECT * FROM nguoidung WHERE email='" + email + "' and password = '" + pass + "'";
		try (Connection kn = CSDL.getConnection()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				nd = new NguoiDung();
				nd.setId(rs.getInt("id"));
				nd.setIdVaiTro(rs.getInt("id_vaitro"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setDiaChi(rs.getString("diachi"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setPassword(rs.getString("password"));
				nd.setEmail(rs.getString("email"));
			}
			return nd;
		} catch (Exception e) {
			return null;
		}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		NguoiDung nd = timNguoiDung("bichle@gmail.com", "bichle");
//		if (nd != null) {
//			System.out.println("có người dùng này " + nd.getHoTen());
//		} else {
//			System.out.println("không có người dùng náy");
//		}
//	}

}
