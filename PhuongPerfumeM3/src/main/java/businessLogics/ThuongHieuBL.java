package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.ThuongHieu;

public class ThuongHieuBL {
	public static List<ThuongHieu> docTatCa(){
		List<ThuongHieu> dsth = new ArrayList<ThuongHieu>();
		String sql = "SELECT * FROM thuonghieu";
		try (Connection con = CSDL.getConnection()){
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ThuongHieu th = new ThuongHieu();
				th.setId(rs.getInt("id"));
				th.setTenThuongHieu(rs.getString("tenthuonghieu"));
				th.setHinhAnh(rs.getString("hinhanh"));
				dsth.add(th);
			}
			return dsth;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ThuongHieu> test = docTatCa();
		test.forEach(ds -> System.out.println(ds.getTenThuongHieu()));
	}

}
