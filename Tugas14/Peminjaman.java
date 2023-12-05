/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import uas.Buku;
import uas.Bukupojo;
import uas.Peminjamanskripsi;
import uas.Skripsi_1;
import uas.Skripsipojo;
import static view.TambahPeminjamanBuku.date;
import static view.ReportTanggalBuku.date;

/**
 *
 * @author HP
 */
public class Peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form Peminjaman
     */
    private Timer refreshTimer;

    private Connection conn;

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Peminjaman> peminjaman;
    ArrayList<Peminjamanskripsi> peminjamanskripsi;

    public static String date(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
        return format.format(date);
    }

    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("UASPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<uas.Peminjaman> querySelectAll = entityManager.createNamedQuery("Peminjaman.findAll", uas.Peminjaman.class);
        List<uas.Peminjaman> results = querySelectAll.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTablebuku.getModel();
        model.setRowCount(0);
        for (uas.Peminjaman data : results) {
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

    private void tampilpeminjamanskripsi() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("UASPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Peminjamanskripsi> querySelectAll = entityManager.createNamedQuery("Peminjamanskripsi.findAll", Peminjamanskripsi.class);
        List<Peminjamanskripsi> results = querySelectAll.getResultList();
        DefaultTableModel model = (DefaultTableModel) jTableskripsi.getModel();
        model.setRowCount(0);
        for (Peminjamanskripsi data : results) {

            Object[] baris = new Object[9];
            baris[0] = data.getIdpeminjaman();
            baris[1] = data.getNama();
            baris[2] = data.getNim();
            baris[3] = data.getProdi();
            baris[4] = data.getAngkatan();
            if (data.getIdskripsi() != null) {
                baris[5] = data.getIdskripsi().getIdskripsi();
            } else {
                baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }
            baris[6] = data.getJudulskripsi();
            baris[7] = date(data.getTanggalpinjam());
            baris[8] = date(data.getTanggalkembali());

            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Peminjaman() {

        initComponents();
        tampil();
        tampilpeminjamanskripsi();

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablebuku = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldbuku = new javax.swing.JTextField();
        jComboBoxbuku = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableskripsi = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextFieldskripsi = new javax.swing.JTextField();
        jComboBoxskripsi = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/q.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("DASHBOARD");

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jTablebuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablebuku);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD");
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

        jTextFieldbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldbukuActionPerformed(evt);
            }
        });
        jTextFieldbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldbukuKeyReleased(evt);
            }
        });

        jComboBoxbuku.setBackground(new java.awt.Color(0, 153, 153));
        jComboBoxbuku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxbuku.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Berdasarkan--", "Judul", "Nama", "NIM", "Prodi", "Angkatan", " " }));

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cetak Berdasarkan Tanggal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 153, 153));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Cetak MAX");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2)
                        .addGap(48, 48, 48)
                        .addComponent(jTextFieldbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jTextFieldbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(76, 76, 76)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(897, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peminjaman Buku", jPanel3);

        jTableskripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID PEMINJAMAN", "NAMA", "NIM", "PRODI", "ANGKATAN", "ID Skripsi", "JUDUL", "Tanggal Pinjam", "Tanggal Kembali"
            }
        ));
        jScrollPane3.setViewportView(jTableskripsi);

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("ADD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 153, 153));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("PRINT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextFieldskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldskripsiActionPerformed(evt);
            }
        });
        jTextFieldskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldskripsiKeyReleased(evt);
            }
        });

        jComboBoxskripsi.setBackground(new java.awt.Color(0, 153, 153));
        jComboBoxskripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxskripsi.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxskripsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Berdasarkan--", "Judul", "Nama", "Prodi", "Angkatan" }));

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cetak Berdasarkan Tanggal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 153, 153));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Cetak MAX");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton5)
                                .addGap(38, 38, 38)
                                .addComponent(jButton6)
                                .addGap(53, 53, 53)
                                .addComponent(jTextFieldskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jTextFieldskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(928, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Peminjaman Skripsi", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SKRIPSI");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("BOOK ");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LAPORAN ");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PEMINJAMAN");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LOG OUT");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(41, 41, 41)
                .addComponent(jLabel11)
                .addGap(45, 45, 45)
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addComponent(jLabel12)
                .addContainerGap(576, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(3, 3, 3)
                    .addComponent(jLabel1)
                    .addContainerGap(1062, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap(902, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new TambahPeminjamanBuku().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new Skripsi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new Book().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        new Inventory2().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String reportPath = "src/report/reportpeminjamanskripsi.jrxml";
            String selection = ((String) jComboBoxskripsi.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldskripsi.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM Peminjamanskripsi p WHERE ";

            switch (selection.toLowerCase()) {
                case "idpeminjaman":
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                case "idskripsi":
                    queryString += "LOWER(p.idskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case "judulskripsi":
                    queryString += "LOWER(p.judulskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case "tanggalpinjam":
                    queryString += "p.tanggalpinjam = :searchDate";
                    // Pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    // Misalkan searchDate adalah objek Date yang berisi tanggal yang diinginkan
                    // Jika Anda menggunakan tipe data string untuk pencarian, Anda perlu mengonversinya ke tipe data Date terlebih dahulu
                    break;

                case "tanggalkembali":
                    queryString += "p.tanggalkembali = :searchDate";
                    // Sama seperti sebelumnya, pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    break;

                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<uas.Peminjamanskripsi> cq = cb.createQuery(uas.Peminjamanskripsi.class);
            Root<uas.Peminjamanskripsi> bok = cq.from(uas.Peminjamanskripsi.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<uas.Peminjamanskripsi> q = em.createQuery(cq);
            List<uas.Peminjamanskripsi> list = q.getResultList();
            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("ID PEMINJAMAN");
            dataModel.addColumn("NAMA");
            dataModel.addColumn("NIM");
            dataModel.addColumn("PRODI");
            dataModel.addColumn("Angkatan");
            dataModel.addColumn("ID skripsi");
            dataModel.addColumn("Judul");
            dataModel.addColumn("Tanggal Pinjam");
            dataModel.addColumn("Tanggal Kembali");

            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            // Misalkan searchDate adalah objek Date yang berisi tanggal yang ingin dicari

            List<uas.Peminjamanskripsi> results = query.getResultList();
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Menyiapkan data untuk ReportTanggalBuku
            for (uas.Peminjamanskripsi data : results) {
                Object[] baris = new Object[9];
                baris[0] = data.getIdpeminjaman();
                baris[1] = data.getNama();
                baris[2] = data.getNim();
                baris[3] = data.getProdi();
                baris[4] = data.getAngkatan();
                if (data.getIdskripsi() != null) {
                    baris[5] = data.getIdskripsi().getIdskripsi();
                } else {
                    baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
                }
                baris[6] = data.getJudulskripsi();
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
            Logger.getLogger(uas.Peminjamanskripsi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String reportPath = "src/report/reportpeminjamanbuku.jrxml";
            String selection = ((String) jComboBoxbuku.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldbuku.getText().trim();
            String searchDate = jTextFieldbuku.getText();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM Peminjaman p WHERE ";

            switch (selection.toLowerCase()) {
                case "idpeminjaman":
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case "tanggalpinjam":
                    queryString += "p.tanggalpinjam = :searchDate";
                    // Pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    // Misalkan searchDate adalah objek Date yang berisi tanggal yang diinginkan
                    // Jika Anda menggunakan tipe data string untuk pencarian, Anda perlu mengonversinya ke tipe data Date terlebih dahulu
                    break;

                case "tanggalkembali":
                    queryString += "p.tanggalkembali = :searchDate";
                    // Sama seperti sebelumnya, pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    break;

                case "judulbuku":
                    queryString += "LOWER(p.judulbuku) LIKE LOWER(:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<uas.Peminjaman> cq = cb.createQuery(uas.Peminjaman.class);
            Root<uas.Peminjaman> bok = cq.from(uas.Peminjaman.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<uas.Peminjaman> q = em.createQuery(cq);
            List<uas.Peminjaman> list = q.getResultList();
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
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            // Misalkan searchDate adalah objek Date yang berisi tanggal yang ingin dicari

            List<uas.Peminjaman> results = query.getResultList();
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Menyiapkan data untuk ReportTanggalBuku
            for (uas.Peminjaman data : results) {
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
            Logger.getLogger(uas.Peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldbukuActionPerformed

    private void jTextFieldbukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldbukuKeyReleased
        // TODO add your handling code here:
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String selection = (String) jComboBoxbuku.getSelectedItem();

            String searchTerm = jTextFieldbuku.getText().trim();
            String searchDate = jTextFieldbuku.getText();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM Peminjaman p WHERE ";

            switch (selection.toLowerCase()) {
                case "idpeminjaman":
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                case "idbuku":
                    queryString += "LOWER(p.judulbuku) LIKE LOWER(:searchTerm)";
                    break;
                case "judulbuku":
                    queryString += "LOWER(p.judulbuku) LIKE LOWER(:searchTerm)";
                    break;
                case "tanggalpinjam":
                    queryString += "p.tanggalpinjam = :searchDate";
                    // Pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    // Misalkan searchDate adalah objek Date yang berisi tanggal yang diinginkan
                    // Jika Anda menggunakan tipe data string untuk pencarian, Anda perlu mengonversinya ke tipe data Date terlebih dahulu
                    break;

                case "tanggalkembali":
                    queryString += "p.tanggalkembali = :searchDate";
                    // Sama seperti sebelumnya, pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    break;

                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Create and execute the JPA query
            EntityManager em = null;

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
                em = emf.createEntityManager();

                TypedQuery<uas.Peminjaman> query = em.createQuery(queryString, uas.Peminjaman.class);
                query.setParameter("searchTerm", "%" + searchTerm + "%");

                List<uas.Peminjaman> results = query.getResultList();

                DefaultTableModel dataModel = new DefaultTableModel();

                // Add columns to the model
                dataModel.addColumn("ID PEMINJAMAN");
                dataModel.addColumn("NAMA");
                dataModel.addColumn("NIM");
                dataModel.addColumn("PRODI");
                dataModel.addColumn("ANGKATAN");
                dataModel.addColumn("ID BUKU");
                dataModel.addColumn("JUDUL");
                dataModel.addColumn("Tanggal Pinjam");
                dataModel.addColumn("Tanggal Kembali");

                // ... tambahkan kolom lain sesuai kebutuhan
                // Add rows to the model
                for (uas.Peminjaman data : results) {
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

                // Set jTableBuku with the created model
                jTablebuku.setModel(dataModel);

            } catch (IllegalArgumentException ex) {
                // Handle the case where no search criteria selected
                ex.printStackTrace();
            } catch (Exception ex) {
                // Handle other exceptions
                ex.printStackTrace();
            } finally {
                if (em != null && em.isOpen()) {
                    em.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldbukuKeyReleased

    private void jTextFieldskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldskripsiActionPerformed

    private void jTextFieldskripsiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldskripsiKeyReleased
        // TODO add your handling code here:
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String selection = (String) jComboBoxskripsi.getSelectedItem();

            String searchTerm = jTextFieldskripsi.getText().trim();
            String searchDate = jTextFieldskripsi.getText();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM Peminjamanskripsi p WHERE ";

            switch (selection.toLowerCase()) {
                case "idpeminjaman":
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                case "idskripsi":
                    queryString += "LOWER(p.idskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case "judulskripsi":
                    queryString += "LOWER(p.judulskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case "tanggalpinjam":
                    queryString += "p.tanggalpinjam = :searchDate";
                    // Pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    // Misalkan searchDate adalah objek Date yang berisi tanggal yang diinginkan
                    // Jika Anda menggunakan tipe data string untuk pencarian, Anda perlu mengonversinya ke tipe data Date terlebih dahulu
                    break;

                case "tanggalkembali":
                    queryString += "p.tanggalkembali = :searchDate";
                    // Sama seperti sebelumnya, pastikan untuk menetapkan parameter tanggal yang dicari ke query
                    break;

                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Create and execute the JPA query
            EntityManager em = null;

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
                em = emf.createEntityManager();

                TypedQuery<uas.Peminjamanskripsi> query = em.createQuery(queryString, uas.Peminjamanskripsi.class);
                query.setParameter("searchTerm", "%" + searchTerm + "%");

                List<uas.Peminjamanskripsi> results = query.getResultList();

                DefaultTableModel dataModel = new DefaultTableModel();

                // Add columns to the model
                dataModel.addColumn("ID PEMINJAMAN");
                dataModel.addColumn("NAMA");
                dataModel.addColumn("NIM");
                dataModel.addColumn("PRODI");
                dataModel.addColumn("ANGKATAN");
                dataModel.addColumn("ID SKRIPSI");
                dataModel.addColumn("JUDUL");
                dataModel.addColumn("Tanggal Pinjam");
                dataModel.addColumn("Tanggal Kembali");

                // ... tambahkan kolom lain sesuai kebutuhan
                // Add rows to the model
                for (uas.Peminjamanskripsi data : results) {
                    Object[] baris = new Object[9];
                    baris[0] = data.getIdpeminjaman();
                    baris[1] = data.getNama();
                    baris[2] = data.getNim();
                    baris[3] = data.getProdi();
                    baris[4] = data.getAngkatan();
                    if (data.getIdskripsi() != null) {
                        baris[5] = data.getIdskripsi().getIdskripsi();
                    } else {
                        baris[5] = ""; //atau nilai default yg sesuai jika data.getidbuku null
                    }
                    baris[6] = data.getJudulskripsi();
                    baris[7] = date(data.getTanggalpinjam());
                    baris[8] = date(data.getTanggalkembali());
                    dataModel.addRow(baris);

                }

                // Set jTableBuku with the created model
                jTablebuku.setModel(dataModel);

            } catch (IllegalArgumentException ex) {
                // Handle the case where no search criteria selected
                ex.printStackTrace();
            } catch (Exception ex) {
                // Handle other exceptions
                ex.printStackTrace();
            } finally {
                if (em != null && em.isOpen()) {
                    em.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldskripsiKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new TambahPeminjamanSkripsi().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new ReportTanggalBuku().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/report/reportPeminjamanbukuTerbanyak.jrxml";
            String selection = ((String) jComboBoxbuku.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldbuku.getText().trim();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
            EntityManager em = emf.createEntityManager();

            String queryString = "SELECT p FROM Peminjaman p WHERE ";

            switch (jComboBoxbuku.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case 1:
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case 2:
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case 3:
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                case 5:
                    queryString += "LOWER(p.idbuku) LIKE LOWER(:searchTerm)";
                    break;
                case 6:
                    queryString += "LOWER(p.judulbuku) LIKE LOWER(:searchTerm)";
                    break;
                case 7:
                    queryString += "LOWER(p.tanggalpinjam) LIKE LOWER(:searchTerm)";
                    break;
                case 8:
                    queryString += "LOWER(p.tanggalkembali) LIKE LOWER(:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected. Selected Criteria: " + selection);
            }

            TypedQuery<uas.Peminjaman> query = em.createQuery(queryString, uas.Peminjaman.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<uas.Peminjaman> results = query.getResultList();

            if (results.isEmpty()) {
                System.out.println("No results found for the given criteria.");
                return;
            }

            // Menghitung ISBN yang paling banyak dipinjam
            Map<String, Integer> idbukuCountMap = new HashMap<>();
            String mostFrequentId = "";
            int maxCount = 0;

            for (uas.Peminjaman peminjaman : results) {
                String idbuku = peminjaman.getIdbuku().getIdbuku();
                int count = idbukuCountMap.getOrDefault(idbuku, 0) + 1;
                idbukuCountMap.put(idbuku, count);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentId = idbuku;
                }
            }

            // Load the JasperReports design file
            // Memuat file desain ReportTanggalBuku (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            // Fill the report with data
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mostFrequentId", mostFrequentId);
            parameter.put("maxCount", maxCount);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
            parameter.put("peminjamanDataSource", dataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

            // Show the report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/report/reportPeminjamskripsiTerbanyak.jrxml";
            String selection = ((String) jComboBoxskripsi.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldskripsi.getText().trim();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
            EntityManager em = emf.createEntityManager();

            String queryString = "SELECT p FROM Peminjamanskripsi p WHERE ";

            switch (jComboBoxbuku.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(p.idpeminjaman) LIKE LOWER(:searchTerm)";
                    break;
                case 1:
                    queryString += "LOWER(p.nama) LIKE LOWER(:searchTerm)";
                    break;
                case 2:
                    queryString += "LOWER(p.nim) LIKE LOWER(:searchTerm)";
                    break;
                case 3:
                    queryString += "LOWER(p.prodi) LIKE LOWER(:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(p.angkatan) LIKE LOWER(:searchTerm)";
                    break;
                case 5:
                    queryString += "LOWER(p.idskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case 6:
                    queryString += "LOWER(p.judulskripsi) LIKE LOWER(:searchTerm)";
                    break;
                case 7:
                    queryString += "LOWER(p.tanggalpinjam) LIKE LOWER(:searchTerm)";
                    break;
                case 8:
                    queryString += "LOWER(p.tanggalkembali) LIKE LOWER(:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected. Selected Criteria: " + selection);
            }

            TypedQuery<uas.Peminjamanskripsi> query = em.createQuery(queryString, uas.Peminjamanskripsi.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<uas.Peminjamanskripsi> results = query.getResultList();

            if (results.isEmpty()) {
                System.out.println("No results found for the given criteria.");
                return;
            }

            // Menghitung ISBN yang paling banyak dipinjam
            Map<String, Integer> idskripsiCountMap = new HashMap<>();
            String mostFrequentId = "";
            int maxCount = 0;

            for (uas.Peminjamanskripsi peminjaman : results) {
                String idskripsi = peminjaman.getIdskripsi().getIdskripsi();
                int count = idskripsiCountMap.getOrDefault(idskripsi, 0) + 1;
                idskripsiCountMap.put(idskripsi, count);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentId = idskripsi;
                }
            }

            // Load the JasperReports design file
            // Memuat file desain ReportTanggalBuku (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            // Fill the report with data
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mostFrequentId", mostFrequentId);
            parameter.put("maxCount", maxCount);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
            parameter.put("peminjamanDataSource", dataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

            // Show the report
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBoxbuku;
    private javax.swing.JComboBox<String> jComboBoxskripsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablebuku;
    private javax.swing.JTable jTableskripsi;
    private javax.swing.JTextField jTextFieldbuku;
    private javax.swing.JTextField jTextFieldskripsi;
    // End of variables declaration//GEN-END:variables
}
