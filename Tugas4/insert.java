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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
public class insert {
    
    public static void main(String[] args) {
        String query = "INSERT INTO mata_kuliah VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner input = new Scanner(System.in);
         try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "1183");
            pstmt = conn.prepareStatement(query);

            System.out.print("Kode_matkul");
            int insert_kode_matkul = input.nextInt();
            
            System.out.print("Nama_matkul");
            Scanner in = new Scanner(System.in);
            String nama_matkul = in.nextLine();
           
            System.out.print("Jumlah SKS");
            int insert_total_sks = input.nextInt();
            
            pstmt.setInt(1, insert_kode_matkul);
            pstmt.setString(2, "  ");
            pstmt.setInt(3, insert_total_sks);
            
            int k = pstmt.executeUpdate();
            if (k > 0) {
                System.out.println("BERHASIL!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
