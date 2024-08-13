package BusinessLogics;

import JavaBeans.LoaiSua;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hv
 */
public class LoaiSuaBL {
    public static List<LoaiSua> DocTatCa(){
        List<LoaiSua> dsls = null;
        try (Connection con = CSDL.LayKetNoi()){
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from loai_sua");
            dsls = new ArrayList<>();
            while(rs.next()){
                LoaiSua ls = new LoaiSua();
                ls.setMaLoai(rs.getString("ma_loai_sua"));
                ls.setTenLoai(rs.getString("ten_loai"));
                dsls.add(ls);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSuaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsls;
    }
}
