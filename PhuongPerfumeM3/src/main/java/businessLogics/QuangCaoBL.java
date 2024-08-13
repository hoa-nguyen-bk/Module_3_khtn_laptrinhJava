package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	public static List<QuangCao> docTatCa() {
		List<QuangCao> ds = new ArrayList<QuangCao>();
		String sql = "SELECT * FROM quangcao";
		try (Connection kn = CSDL.getConnection()) {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setId(rs.getInt("id"));
				qc.setHinhAnh(rs.getString("hinhanh"));
				qc.setThongDiep(rs.getString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				ds.add(qc);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static void main(String[] args) {
		List<QuangCao> ds = docTatCa();
		if (ds != null) {
			ds.forEach(qc->System.out.println(qc.getThongDiep()));
		} else {
			System.out.println("danh sách rỗng");
		}
	}

}
