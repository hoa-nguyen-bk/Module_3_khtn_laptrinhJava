package businessLogic;

import java.util.List;

import org.hibernate.Session;

import entities.HangSua;
public class HangSuaBL {
	public static List<HangSua> docTatCa() {
		String sql = "SELECT hs FROM hang_sua hs";
		try (Session session = Database.getFactory().openSession()) {
			return session.createQuery(sql, HangSua.class).list();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	public static void main(String[] args) {
		List<HangSua> ds = docTatCa();
		ds.forEach(s->System.out.println(s.getTenHangSua()));
	}
}
