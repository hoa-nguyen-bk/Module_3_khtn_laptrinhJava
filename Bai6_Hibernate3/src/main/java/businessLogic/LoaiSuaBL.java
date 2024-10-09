package businessLogic;

import java.util.List;

import org.hibernate.Session;

import entities.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> docTatCa(){
		String sql = "SELECT ls FROM loai_sua ls";
		try (Session session = Database.getFactory().openSession()){
			return session.createQuery(sql, LoaiSua.class).list();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	public static void main(String[] args) {
		List<LoaiSua> ds = docTatCa();
		ds.forEach(ls->System.out.println(ls.getMaLoaiSua()+" - "+ls.getTenLoai()));
	}

}
