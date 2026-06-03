/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.sql.Connection;

public class Main {
    
 public static void main(String[] args) {

        try {

            Connection con = DBConnection.createConnection();

            if (con != null) {
                System.out.println("Database Connected Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   
    
}
