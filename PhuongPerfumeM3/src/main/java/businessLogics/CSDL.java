package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;

public class CSDL {
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3309/phuong_perfume?useUnicode=true&characterEncoding=UTF-8";
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","");
			return connection;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
//	public static void main(String[] args) {
//		Connection kn = getConnection();
//		if(kn!=null) {
//			System.out.println("ket noi suc");
//		} else {
//			System.out.println("failt");
//		}
//
//	}

}
