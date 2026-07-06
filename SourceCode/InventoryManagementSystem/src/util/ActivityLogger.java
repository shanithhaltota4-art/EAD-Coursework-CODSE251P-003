/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import Main.DBConnection;        
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author shani
 */
public class ActivityLogger {
    
     public static void log(String activity,
                           String module,
                           String userId,
                           String username) {

        try {

            Connection con = DBConnection.createConnection();

            String sql = "INSERT INTO activity_log "
                    + "(activity,module,user_id,username) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, activity);
            ps.setString(2, module);
            ps.setString(3, userId);
            ps.setString(4, username);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    
}
