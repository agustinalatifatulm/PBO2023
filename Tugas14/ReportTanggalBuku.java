/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import uas.Peminjaman;
import uas.Skripsi_1;
import static view.TambahPeminjamanBuku.date;

/**
 *
 * @author HP
 */
public class ReportTanggalBuku extends javax.swing.JFrame {

    /**
     * Creates new form ReportTanggalBuku
     */
    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Peminjaman> peminjaman;

    public static String date(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
        return format.format(date);
    }

    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("UASPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Peminjaman> querySelectAll = entityManager.createNamedQuery("Peminjaman.findAll", Peminjaman.class);
        List<Peminjaman> results = querySelectAll.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Peminjaman data : results) {
            Object[] baris = new Object[9];
            baris[0] = data.getIdpeminjaman();
            baris[1] = data.getNama();
            baris[2] = data.getNim();
            baris[3] = data.getProdi();
            baris[4] = data.getAngkatan();
            if (data.getIdbuku() != null) {
                baris[5] = data.getIdbuku().getIdbuku();
            } else {
                baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }
            baris[6] = data.getJudulbuku();
            baris[7] = date(data.getTanggalpinjam());
            baris[8] = date(data.getTanggalkembali());

            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public ReportTanggalBuku() {
        try {
            peminjaman = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Perpustakaan", "postgres", "1183");
            tampil();
            // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)

            tampil();
        } catch (SQLException ex) {
            Logger.getLogger(LaporanPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PEMINJAMAN", "NAMA", "NIM", "PRODI", "ANGKATAN", "ID BUKU", "JUDUL", "Tanggal Pinjam", "Tanggal Kembali"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CARI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Dari Tanggal");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Sampai Tanggal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(166, 166, 166)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date tanggalMulai = jDateChooser1.getDate();
        Date tanggalkembali = jDateChooser2.getDate();

        if (tanggalMulai == null && tanggalkembali == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit the method if the date is not selected
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
        EntityManager em = emf.createEntityManager();

        String queryString = "SELECT p FROM Peminjaman p WHERE p.tanggalpinjam BETWEEN :startdate AND :enddate";

        TypedQuery<Peminjaman> query = em.createQuery(queryString, Peminjaman.class);
        query.setParameter("startdate", tanggalMulai);
        query.setParameter("enddate", tanggalkembali);

        List<Peminjaman> results = query.getResultList();

        DefaultTableModel dataModel = new DefaultTableModel();
        // Add columns to the model
        dataModel.addColumn("ID PEMINJAMAN");
        dataModel.addColumn("NAMA");
        dataModel.addColumn("NIM");
        dataModel.addColumn("PRODI");
        dataModel.addColumn("Angkatan");
        dataModel.addColumn("ID buku");

        dataModel.addColumn("Judul");
        
        dataModel.addColumn("Tanggal Pinjam");
        dataModel.addColumn("Tanggal Kembali");

        // ... tambahkan kolom lain sesuai kebutuhan
        for (Peminjaman data : results) {
            Object[] baris = new Object[9];
            baris[0] = data.getIdpeminjaman();
            baris[1] = data.getNama();
            baris[2] = data.getNim();
            baris[3] = data.getProdi();
            baris[4] = data.getAngkatan();
            if (data.getIdbuku() != null) {
                baris[5] = data.getIdbuku().getIdbuku();
            } else {
                baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }
            baris[6] = data.getJudulbuku();
            baris[7] = date(data.getTanggalpinjam());
            baris[8] = date(data.getTanggalkembali());
            dataModel.addRow(baris);

        }

        // Set jTable1 with the created model
        jTable1.setModel(dataModel);
        System.out.println(results);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/report/laporanTglBuku.jrxml";
            Date tanggalMulai = jDateChooser1.getDate();
            Date tanggalkembali = jDateChooser2.getDate();

            if (tanggalMulai == null && tanggalkembali == null) {
                JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Exit the method if the date is not selected
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            String queryString = "SELECT p FROM Peminjaman p WHERE p.tanggalpinjam BETWEEN :startdate AND :enddate";

            TypedQuery<Peminjaman> query = em.createQuery(queryString, Peminjaman.class);
            query.setParameter("startdate", tanggalMulai);
            query.setParameter("enddate", tanggalkembali);

            List<Peminjaman> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("ID PEMINJAMAN");
            dataModel.addColumn("NAMA");
            dataModel.addColumn("NIM");
            dataModel.addColumn("PRODI");
            dataModel.addColumn("Angkatan");
            dataModel.addColumn("ID buku");

            dataModel.addColumn("Judul");
            
            dataModel.addColumn("Tanggal Pinjam");
            dataModel.addColumn("Tanggal Kembali");

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Peminjaman> cq = cb.createQuery(Peminjaman.class);
            Root<Peminjaman> bok = cq.from(Peminjaman.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("startdate", tanggalMulai);
            parameter.put("enddate", tanggalkembali);
            // ... tambahkan kolom lain sesuai kebutuhan

            for (Peminjaman data : results) {
                Object[] baris = new Object[9];
                baris[0] = data.getIdpeminjaman();
                baris[1] = data.getNama();
                baris[2] = data.getNim();
                baris[3] = data.getProdi();
                baris[4] = data.getAngkatan();
                if (data.getIdbuku() != null) {
                baris[5] = data.getIdbuku().getIdbuku();
            } else {
                baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }
                baris[6] = data.getJudulbuku();
                baris[7] = date(data.getTanggalpinjam());
                baris[8] = date(data.getTanggalkembali());
                dataModel.addRow(baris);

            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain ReportTanggalBuku (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ReportTanggalBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportTanggalBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportTanggalBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportTanggalBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportTanggalBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportTanggalBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
