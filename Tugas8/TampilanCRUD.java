/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CRUD;

/**
 *
 * @author HP
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
public class TampilanCRUD extends javax.swing.JFrame {
    
    private Timer refreshTimer;

    private Connection conn;

    /**
     * Creates new form TampilanCRUD
     */
    
     public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
      ArrayList<bukuPOJO> buku;
      
     private int InputData(Connection conn,String  Isbn, String judul, String tahunterbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO buku (\" Isbn\",\"judul\",\"tahunterbit\",\"penerbit\") VALUES(?,?,?,?)");
        pst.setString(1,  Isbn);
        pst.setString(2, judul);
        pst.setString(3,tahunterbit);
        pst.setString(4,penerbit);
        return pst.executeUpdate();
    }
     
     private void tampil(Connection conn) {
         buku.clear();
         try{
            String sql = "select * from buku";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               bukuPOJO data = new bukuPOJO();
                data.setIsbn(String.valueOf(rs.getObject(1)));
                data.setJudul(String.valueOf(rs.getObject(2)));
                data.setTahunterbit(String.valueOf(rs.getObject(3)));
                data.setPenerbit(String.valueOf(rs.getObject(4)));
                buku.add(data);
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (bukuPOJO data : buku) {

                Object[] baris = new Object[4];
                baris[0] = data.getISBN();
                baris[1] = data.getJudul();
                baris [2] = data.getTahunterbit();
                baris [3] = data.getPenerbit();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TampilanCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     private void kosongkan_form() {
        jTextFieldisbn.setEditable(true);
        jTextFieldisbn.setText(null);
        jTextFieldjudul.setText(null);
        jTextFieldtahunterbit.setText(null);
        jTextFieldpenerbit.setText(null);
    }

     private int UpdateData(Connection conn, String ISBN, String judul, String tahunterbit, String penerbit) throws SQLException{
        PreparedStatement pst = conn.prepareStatement("UPDATE buku SET \"judul\" = ?,\"tahunterbit\" = ?,\"penerbit\" = ? WHERE \"ISBN\" = ?");
        pst.setString(1, judul);
        pst.setString(2,tahunterbit);
        pst.setString(3, penerbit);
        pst.setString(4, ISBN);
        return pst.executeUpdate();
     }
     private int HapusData(Connection conn, String ISBN)throws SQLException{
         PreparedStatement pst = conn.prepareStatement("DELETE FROM buku WHERE \"ISBN\" = ?");
         pst.setString(1, ISBN);
         return pst.executeUpdate();
     }
         
     

    public TampilanCRUD() {
         try {
             buku = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/crud", "postgres", "1183");
            tampil(conn);
            // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)
            refreshTimer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tampil(conn);
                }
            });
            refreshTimer.start();
            tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(TampilanCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldisbn = new javax.swing.JTextField();
        jTextFieldjudul = new javax.swing.JTextField();
        jTextFieldtahunterbit = new javax.swing.JTextField();
        jTextFieldpenerbit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonsave = new javax.swing.JButton();
        jButtonupdate = new javax.swing.JButton();
        jButtonhapus = new javax.swing.JButton();
        jButtoncetak = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DATA BUKU");

        jLabel2.setText("ISBN");

        jLabel3.setText("JUDUL");

        jLabel4.setText("TAHUN TERBIT");

        jLabel5.setText("PENERBIT");

        jTextFieldisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldisbnActionPerformed(evt);
            }
        });

        jTextFieldjudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldjudulActionPerformed(evt);
            }
        });

        jTextFieldtahunterbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldtahunterbitActionPerformed(evt);
            }
        });

        jTextFieldpenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldpenerbitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "JUDUL", "TAHUN TERBIT", "PENERBIT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonsave.setText("SAVE");
        jButtonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsaveActionPerformed(evt);
            }
        });

        jButtonupdate.setText("UPDATE");
        jButtonupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdateActionPerformed(evt);
            }
        });

        jButtonhapus.setText("HAPUS");
        jButtonhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusActionPerformed(evt);
            }
        });

        jButtoncetak.setText("CETAK");
        jButtoncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakActionPerformed(evt);
            }
        });

        jButton2.setText("IMPORT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldisbn)
                            .addComponent(jTextFieldjudul)
                            .addComponent(jTextFieldtahunterbit)
                            .addComponent(jTextFieldpenerbit))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonsave)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtoncetak)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonupdate)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonhapus))
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldtahunterbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldpenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonsave)
                            .addComponent(jButtonupdate)
                            .addComponent(jButtonhapus))
                        .addGap(29, 29, 29)
                        .addComponent(jButtoncetak)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldisbnActionPerformed

    private void jTextFieldjudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldjudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldjudulActionPerformed

    private void jButtonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsaveActionPerformed
        // TODO add your handling code here:
       String Isbn = jTextFieldisbn.getText().trim();
        String judul = jTextFieldjudul.getText();
        String tahunterbit = jTextFieldtahunterbit.getText();
        String penerbit = jTextFieldpenerbit.getText();
       
        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("latihanCRUDbukuPU").createEntityManager();
        entityManager.getTransaction().begin();
       Buku b = new Buku();
        b.setIsbn(Isbn);
        b.setJudul(judul);
        b.setTahunterbit(tahunterbit);
        b.setPenerbit(penerbit);
        entityManager.persist(b);
        entityManager.getTransaction().commit();
      
        
        
        // akhir persistence
        
        jTextFieldisbn.setText("");
        jTextFieldjudul.setText("");
        jTextFieldtahunterbit.setText(" ");
        jTextFieldpenerbit.setText(" ");
        
       
    }//GEN-LAST:event_jButtonsaveActionPerformed

    private void jButtonupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdateActionPerformed
        // TODO add your handling code here:
       String Isbn = jTextFieldisbn.getText().trim();
        String judul = jTextFieldjudul.getText();
        String tahunterbit = jTextFieldtahunterbit.getText();
        String penerbit = jTextFieldpenerbit.getText();
       

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("latihanCRUDbukuPU");
        EntityManager em = emf.createEntityManager();
        Buku b = new Buku();
        b.setIsbn(Isbn);
        b.setJudul(judul); 
        b.setTahunterbit(tahunterbit);
        b.setPenerbit(penerbit);
        
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        

        jTextFieldisbn.setText("");
        jTextFieldjudul.setText("");
        jTextFieldtahunterbit.setText("");
        jTextFieldpenerbit.setText("");
      

        
                          
    }//GEN-LAST:event_jButtonupdateActionPerformed

    private void jButtonhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusActionPerformed
        // TODO add your handling code here:
        String Isbn = jTextFieldisbn.getText().trim();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("latihanCRUDbukuPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Buku b = em.find(Buku.class, Isbn);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextFieldisbn.setText("");
        kosongkan_form();
    }//GEN-LAST:event_jButtonhapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
         String isbn = jTable1.getValueAt(baris, 0).toString();
        jTextFieldisbn.setText(isbn);

        String judul = jTable1.getValueAt(baris, 1).toString();
        jTextFieldjudul.setText(judul);

        String tahunterbit= jTable1.getValueAt(baris, 2).toString();
        jTextFieldtahunterbit.setText(tahunterbit);
        
        String penerbit= jTable1.getValueAt(baris, 3).toString();
        jTextFieldpenerbit.setText(penerbit);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtoncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetakActionPerformed
        // TODO add your handling code here:
       String reportPath = "src/CRUD/report2.jrxml";
            // awal persistence
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("latihanCRUDbukuPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Buku> cq = cb.createQuery(Buku.class);
            Root<Buku> bok = cq.from(Buku.class);
            cq.select(bok);

            TypedQuery<Buku> q = em.createQuery(cq);
            List<Buku> list = q.getResultList();
            Query query = em.createQuery("SELECT b FROM Buku b");
            List<Buku> result = query.getResultList();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);

             try {
                JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
                JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
                JasperViewer viewer = new JasperViewer(print, false);
                viewer.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(TampilanCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }

            em.getTransaction().commit();
            em.close();
            emf.close();
            // akhir persistence
           
        
        
    }//GEN-LAST:event_jButtoncetakActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser filechooser = new JFileChooser();

                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    
                    EntityManager entityManager = Persistence.createEntityManagerFactory("latihanCRUDbukuPU").createEntityManager();
                    entityManager.getTransaction().begin();
                    
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    String fi = f.getName();
                    //Parsing CSV Data
                    System.out.print(filepath);
                    DefaultTableModel csv_data = new DefaultTableModel();

                    try {

                        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                        org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                        for (CSVRecord csvRecord : csvParser) {

                        Buku z = new Buku();
                        z.setIsbn(csvRecord.get(0));
                        z.setJudul(csvRecord.get(1));
                        z.setTahunterbit(csvRecord.get(2));
                        z.setPenerbit(csvRecord.get(3));
                        entityManager.persist(z);
                        
                        }
                        
                    } catch (Exception ex) {
                        System.out.println("Error in Parsing CSV File");
                    }
                    
                    entityManager.getTransaction().commit();}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldpenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldpenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldpenerbitActionPerformed

    private void jTextFieldtahunterbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldtahunterbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldtahunterbitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TampilanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TampilanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TampilanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TampilanCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtoncetak;
    private javax.swing.JButton jButtonhapus;
    private javax.swing.JButton jButtonsave;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldisbn;
    private javax.swing.JTextField jTextFieldjudul;
    private javax.swing.JTextField jTextFieldpenerbit;
    private javax.swing.JTextField jTextFieldtahunterbit;
    // End of variables declaration//GEN-END:variables

   

    
}
