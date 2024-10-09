package businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Sua;

public class SuaBL {
	public static List<Sua> docTatCa() {
		String sql = "SELECT s FROM Sua s LEFT JOIN FETCH s.hangSua LEFT JOIN FETCH s.loaiSua";
		try (Session session = Database.getFactory().openSession()) {
			return session.createQuery(sql, Sua.class).list();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static List<Sua> docTheoMaHang(String maHang) {
		String sql = "SELECT s FROM Sua s LEFT JOIN FETCH s.hangSua LEFT JOIN FETCH s.loaiSua"
				+ " WHERE s.hangSua.maHangSua = :maHang";
		try (Session session = Database.getFactory().openSession()){
			return session.createQuery(sql, Sua.class).setParameter("maHang", maHang).list();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static List<Sua> docTheoMaHangLoaiTen(String maHang, String maLoai, String ten) {
		String sql = "SELECT s FROM Sua s LEFT JOIN FETCH s.hangSua LEFT JOIN FETCH s.loaiSua"
				+ " WHERE s.hangSua.maHangSua = :maHang" 
				+ " AND s.loaiSua.maLoaiSua = :maLoai" 
				+ " AND s.tenSua like :ten";
		try (Session session = Database.getFactory().openSession()){
			return session.createQuery(sql, Sua.class)
					.setParameter("maHang", maHang)
					.setParameter("maLoai", maLoai)
					.setParameter("ten", "%"+ ten +"%")
					.list();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static List<Sua> docBanChay(int top) {
		String sql = "SELECT s, sum(ct.soLuong) AS tsl FROM Sua s JOIN s.ctHoadons ct"+
						" LEFT JOIN FETCH s.hangSua LEFT JOIN FETCH s.loaiSua"+
						" GROUP BY s ORDER BY tsl DESC";
		try (Session session = Database.getFactory().openSession()) {
			List<Object[]> dsObj = session.createQuery(sql, Object[].class).setFirstResult(0).setMaxResults(top).list();
			List<Sua> ds = new ArrayList<Sua>();
			for(Object[] ob:dsObj) {
				Sua s = (Sua) ob[0];
				ds.add(s);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static void main(String[] args) {
//		List<Sua> ds = docTatCa();
//		List<Sua> ds = docTheoMaHang("DL");
//		List<Sua> ds = docTheoMaHangLoaiTen("DL", "SB", "gái");
		List<Sua> ds = docBanChay(3);
		ds.forEach(s -> System.out.println(s.getTenSua() + " - " + s.getHangSua().getTenHangSua() + " - "
				+ s.getLoaiSua().getTenLoai() + " - " + s.getDonGia()));
	}
}
