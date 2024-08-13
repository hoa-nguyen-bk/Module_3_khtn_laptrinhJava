package businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
	private static Connection con;
	private static String url="jdbc:mysql://localhost:3309/ql_bansua?useUnicode=true&characterEncoding=UTF-8";
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return con;
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Connection kn = getCon();
//		if(kn!=null) {
//			System.out.println("Kết nối thành công");
//		} else {
//			System.out.println("Kết nối thất bại");
//		}
//	}

}
