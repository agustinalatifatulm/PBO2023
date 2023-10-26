/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud1;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javaapplication7.JavaApplication7.DB_URL;
import static javaapplication7.JavaApplication7.PASS;
import static javaapplication7.JavaApplication7.QUERY;
import static javaapplication7.JavaApplication7.USER;
public class dosenTabel {
    static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASS = "1183";
    static final String QUERY = "SELECT * FROM dosen";
    
    public static void main(String[] args) {
        // TODO code application logic here
        try ( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                //Display values
                System.out.println("NIP: " + String.valueOf(rs.getObject(1)));
                System.out.println(", nama dosen: " + String.valueOf(rs.getObject(2)));
                System.out.println(", alamat: " + String.valueOf(rs.getObject(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
