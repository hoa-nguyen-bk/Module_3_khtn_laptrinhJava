package businessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBean.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa(){
		List<LoaiSua> ds = new ArrayList<LoaiSua>();
		String sql = "SELECT * FROM loai_sua";
		try (Connection con = CSDL.getCon()){
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoai(rs.getString("ma_loai_sua"));
				ls.setTenLoai(rs.getString("ten_loai"));
				ds.add(ls);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<LoaiSua> ds = docTatCa();
		ds.forEach(ls->System.out.println(ls.getMaLoai()+" - "+ls.getTenLoai()));
	}

}
