package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import javaBeans.Publisher;

public class PublisherBL {
	public static List<Publisher> docTatCa() {
		List<Publisher> ds = new ArrayList<Publisher>();
		String sql = "SELECT * FROM publisher";
		try (Connection con = CSDL.getConnection()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherid"));
				p.setPublisherName(rs.getString("publishername"));
				ds.add(p);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return null;
		}
	}

	public static Publisher docTheoId(int id) {
		Publisher p = null;
		String sql = "SELECT * FROM publisher WHERE publisherid = " + id;

		try (Connection con = CSDL.getConnection()) {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				p = new Publisher();
				p.setPublisherId(rs.getInt("publisherid"));
				p.setPublisherName(rs.getString("publishername"));

			}
			return p;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			return null;
		}
	}
	
	public static int add(Publisher p) {
		String sql = "INSERT INTO publisher(publishername) values (?)";
		try (Connection kn = CSDL.getConnection()){
			PreparedStatement pst = (PreparedStatement) kn.prepareStatement(sql);
			pst.setString(1, p.getPublisherName());
			return pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	public static int edit(Publisher p) {
		String sql = "UPDATE publisher SET publishername = ? WHERE publisherid = ?";
		try (Connection kn = CSDL.getConnection()){
			PreparedStatement pst = (PreparedStatement) kn.prepareStatement(sql);
			pst.setString(1, p.getPublisherName());
			pst.setInt(2, p.getPublisherId());
			return pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	public static int del(int id) {
		String sql = "DELETE FROM publisher WHERE publisherid = "+id;
		try (Connection kn = CSDL.getConnection()){
			Statement stm = kn.createStatement();
			return stm.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Publisher> ds = docTatCa();
		ds.forEach(p->System.out.println(p.getPublisherName()));
		
		Publisher p = docTheoId(1);
		System.out.println(p.getPublisherId()+" - "+ p.getPublisherName());
		
		Publisher pnew = new Publisher();
		pnew.setPublisherName("bb");
//		System.out.println(add(pnew));
//		pnew.setPublisherName("bb");
		pnew.setPublisherId(18);
		System.out.println(edit(pnew));
		
//		System.out.println(del(pnew.getPublisherId()));
//		System.out.println(del(17));
	}

}
