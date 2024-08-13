package BusinessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hv
 */
public class CSDL {
    public static Connection LayKetNoi(){
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3309/ql_bansua?useUnicode=true&characterEncoding=UTF-8";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
//    public static void main(String[] args) {
//		Connection kn = LayKetNoi();
//		if(kn!=null) {
//			System.out.println("ket noi success");
//		} else {
//			System.out.println("failt");
//		}
//	}
}
