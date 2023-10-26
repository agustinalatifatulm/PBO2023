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

public class Delete {
     static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASS = "1183";
    static final String QUERY = "DELETE * FROM dosen";
    
    public static void main(String[] args) {
        String query = "DELETE FROM dosen WHERE \"NIP\" = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "1183");
            pstmt = conn.prepareStatement(query);
            System.out.println("Masukkan id yang hendak dihapus: ");
            Scanner in = new Scanner(System.in);
            String hapus = in.nextLine();
            int hapusID = Integer.parseInt(hapus);
            pstmt.setInt(1, hapusID);
            int k = pstmt.executeUpdate();
            if (k > 0) {
                System.out.println("Hapus id " + hapus + " BERHASIL !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
            }
    }
    
}
}
