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


import java.util.Scanner;
public class Update {
     static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASS = "1183";
    
    
    public static void main(String[] args) {
        
        try ( Scanner scan = new Scanner(System.in);
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
              
            if (conn != null) {
                System.out.println("Koneksi sukses!");
        
                System.out.println("Masukkan NIM yang akan diperbarui : ");
                String NIMlama = scan.nextLine();
                
                System.out.println("Masukkan Nama : "); 
                String namaBaru = scan.nextLine();
                
                System.out.println("Alamat : ");
                String total_sks = scan.nextLine();
                
            String QUERY = "UPDATE mahasiswa SET \"Nama\" = ?, \"Alamat\" = ? WHERE \"NIM\" = ?";
       
                try ( PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
                   
                    preparedStatement.setString(1, namaBaru);
                    preparedStatement.setString(2, total_sks);
                    preparedStatement.setString(3, NIMlama);
                    preparedStatement.executeUpdate();
                    
                    int rowsUpdated = preparedStatement.executeUpdate();
                    if(rowsUpdated > 0){
                        System.out.println("Data berhasil diupdate");
                    }else{
                        System.out.println("data dengan id yang dimasukkan tidak ditemukan.");
                    }

                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        
        
            }
        
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    }
}       
      
        
  
   
            
       