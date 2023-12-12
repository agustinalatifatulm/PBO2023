/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.text.MessageFormat.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import uas.Buku;
import static uas.Buku_.idbuku;
import uas.Bukupojo;
import uas.Peminjaman;
import uas.Skripsi_1;
import static view.LaporanPeminjaman.date;
import static view.ReportTanggalBuku.date;

/**
 *
 * @author HP
 */
public class TambahPeminjamanBuku extends javax.swing.JFrame {

    private Timer refreshTimer;

    private Connection conn;

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    ArrayList<Peminjaman> peminjaman;
    ArrayList<Buku> buku;

    public static String date(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
        return format.format(date);
    }

    /**
     * Creates new form TambahPeminjamanBuku
     */
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

    private void tampilbuku() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("UASPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Buku> querySelectAll = entityManager.createNamedQuery("Buku.findAll", Buku.class);
        List<Buku> results = querySelectAll.getResultList();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (Buku data : results) {

            Object[] baris = new Object[8];
            baris[0] = data.getIdbuku();
            baris[1] = data.getIsbn();
            baris[2] = data.getJudul();
            baris[3] = data.getKategori();
            baris[4] = data.getPengarang();
            baris[5] = data.getPenerbit();
            baris[6] = data.getTahun();
            baris[7] = data.getJumlahhalaman();

            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    private void kosongkan_form() {
        jTextFieldid.setEditable(true);
        jTextFieldid.setText(null);
        jTextFieldnama.setText(null);
        jTextFieldnim.setText(null);
        jTextFieldprodi.setText(null);
        jDatepinjam.setDate(null);
        jDatekembali.setDate(null);
        jTextFieldangkatan.setText(null);
        jTextFieldidbuku.setText(null);
        jTextFieldjudul.setText(null);

    }

    public TambahPeminjamanBuku() {

        initComponents();

        tampil();
        // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)
        tampilbuku();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextFieldcari = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextFieldid = new javax.swing.JTextField();
        jTextFieldnama = new javax.swing.JTextField();
        jTextFieldnim = new javax.swing.JTextField();
        jTextFieldprodi = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldjudul = new javax.swing.JTextField();
        jDatepinjam = new com.toedter.calendar.JDateChooser();
        jDatekembali = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldangkatan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldidbuku = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jDialog1.setSize(new java.awt.Dimension(600, 500));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID BUKU", "ISBN", "JUDUL BUKU", "KATEGORI", "PENGARANG", "PENERBIT", "TAHUN", "HALAMAN"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTextFieldcari.setText("--Cari berdasarkan--");
        jTextFieldcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldcariKeyReleased(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--cari--", "Judul", "Kategori", "Pengarang", "Penerbit", "Tahun" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jTextFieldcari, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/q.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1037, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1037, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ID PEMINJAMAN");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("NIM");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("PRODI");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Tanggal Pinjam");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Tanggal Kembali");

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldidActionPerformed(evt);
            }
        });

        jTextFieldnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnimActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("JUDUL BUKU");

        jTextFieldjudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldjudulActionPerformed(evt);
            }
        });

        jDatepinjam.setDateFormatString("yyyy MM dd");

        jDatekembali.setDateFormatString("yyyy MM dd");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("ANGKATAN");

        jTextFieldangkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldangkatanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("ID BUKU");

        jTextFieldidbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldidbukuActionPerformed(evt);
            }
        });

        jButton4.setText("---");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Import");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldprodi, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(138, 138, 138)
                        .addComponent(jDatekembali, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldnim, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldnama, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDatepinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(138, 138, 138)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldidbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldnim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldprodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDatepinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(8, 8, 8)
                                .addComponent(jDatekembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String idpeminjaman = jTextFieldid.getText();
        String nama = jTextFieldnama.getText();
        String nim = jTextFieldnim.getText();
        String prodi = jTextFieldprodi.getText();
        String tanggalpinjam = format.format(jDatepinjam.getDate());
        String tanggalkembali = format.format(jDatekembali.getDate());
        String judulbuku = jTextFieldjudul.getText();
        String angkatan = jTextFieldangkatan.getText();
        String idbuku = jTextFieldidbuku.getText();

// awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("UASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Buku wm = entityManager.find(Buku.class, idbuku);

        Peminjaman p = new Peminjaman();

        // Ambil langsung Date dari JDateChooser
// Set tanggal peminjaman buku
        p.setIdpeminjaman(idpeminjaman);

        p.setNama(nama);
        p.setNim(nim);
        p.setProdi(prodi);
        try {
            Date datePeminjaman = format.parse(tanggalpinjam);// Ambil langsung Date dari JDateChooser
            Date dateKembali = format.parse(tanggalkembali); // Ambil langsung Date dari JDateChooser
            p.setTanggalpinjam(datePeminjaman);
            p.setTanggalkembali(dateKembali);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setAngkatan(angkatan);
        p.setIdbuku(wm);
        p.setJudulbuku(judulbuku);

        entityManager.persist(p);

        entityManager.getTransaction().commit();
// akhir persistence
        if (!idbuku.isEmpty() && !idpeminjaman.isEmpty() && nama.isEmpty() && nim.isEmpty() && prodi.isEmpty() && angkatan.isEmpty() && judulbuku.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Save anda gagal");

            new TambahPeminjamanBuku().setVisible(true);
            this.dispose();

            kosongkan_form();
        } else {
            JOptionPane.showMessageDialog(this, "Save success");

            kosongkan_form();
        }

// Membersihkan nilai dari komponen GUI
        jTextFieldid.setText("");
        jTextFieldnama.setText("");
        jTextFieldnim.setText("");
        jTextFieldprodi.setText("");
        jDatepinjam.setDate(null);
        jDatekembali.setDate(null);
        jTextFieldidbuku.setText("");
        jTextFieldjudul.setText("");
        jTextFieldangkatan.setText("");

        tampil();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldnimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnimActionPerformed

    private void jTextFieldjudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldjudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldjudulActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String idpeminjaman = jTextFieldid.getText();
        String nama = jTextFieldnama.getText();
        String nim = jTextFieldnim.getText();
        String prodi = jTextFieldprodi.getText();
        String tanggalpinjam = format.format(jDatepinjam.getDate());
        String tanggalkembali = format.format(jDatekembali.getDate());
        String judulbuku = jTextFieldjudul.getText();
        String angkatan = jTextFieldangkatan.getText();
        String idbuku = jTextFieldidbuku.getText();

// awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
        EntityManager em = emf.createEntityManager();
        Buku wm = em.find(Buku.class, idbuku);
        Peminjaman p = new Peminjaman();

        p.setIdpeminjaman(idpeminjaman);

        p.setNama(nama);
        p.setNim(nim);
        p.setProdi(prodi);
        try {
            Date datePeminjaman = format.parse(tanggalpinjam);// Ambil langsung Date dari JDateChooser
            Date dateKembali = format.parse(tanggalkembali); // Ambil langsung Date dari JDateChooser
            p.setTanggalpinjam(datePeminjaman);
            p.setTanggalkembali(dateKembali);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        p.setAngkatan(angkatan);
        p.setIdbuku(wm);
        p.setJudulbuku(judulbuku);
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
// akhir persistence
        if (!idbuku.isEmpty() && !idpeminjaman.isEmpty() && nama.isEmpty() && nim.isEmpty() && prodi.isEmpty() && angkatan.isEmpty() && judulbuku.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Update anda gagal");

            new TambahBuku().setVisible(true);
            this.dispose();

            kosongkan_form();
        } else {
            JOptionPane.showMessageDialog(this, "Update success");

            kosongkan_form();
        }
// Membersihkan nilai dari komponen GUI
        jTextFieldid.setText("");
        jTextFieldnama.setText("");
        jTextFieldnim.setText("");
        jTextFieldprodi.setText("");
        jDatepinjam.setDate(null);
        jDatekembali.setDate(null);
        jTextFieldjudul.setText("");
        jTextFieldangkatan.setText("");

        tampil();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String idpeminjaman = jTable1.getValueAt(baris, 0).toString();
        jTextFieldid.setText(idpeminjaman);

        String nama = jTable1.getValueAt(baris, 1).toString();
        jTextFieldnama.setText(nama);

        String nim = jTable1.getValueAt(baris, 2).toString();
        jTextFieldnim.setText(nim);

        String prodi = jTable1.getValueAt(baris, 3).toString();
        jTextFieldprodi.setText(prodi);

        String pinjam = jTable1.getValueAt(baris, 7).toString();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
            java.util.Date d = format.parse(pinjam);
            jDatepinjam.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        }

        String kembali = jTable1.getValueAt(baris, 8).toString();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
            java.util.Date d = format.parse(kembali);
            jDatekembali.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesua
        }
        String idbuku = jTable1.getValueAt(baris, 5).toString();
        jTextFieldidbuku.setText(idbuku);

        String judulbuku = jTable1.getValueAt(baris, 6).toString();
        jTextFieldjudul.setText(judulbuku);

        String angkatan = jTable1.getValueAt(baris, 4).toString();
        jTextFieldangkatan.setText(angkatan);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       String idpeminjaman = jTextFieldid.getText().trim();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Peminjaman p = em.find(Peminjaman.class, idpeminjaman);

        em.remove(p);
        em.getTransaction().commit();
        // akhir persistence

        // akhir persistence
        if (!idpeminjaman.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Delete Data Berhasil");

            new TambahPeminjamanBuku().setVisible(true);
            this.dispose();

            kosongkan_form();
        } else {
            JOptionPane.showMessageDialog(this, "Delete Data Gagal");

            kosongkan_form();
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        jTextFieldid.setText("");
        kosongkan_form();
        tampil();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldangkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldangkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldangkatanActionPerformed

    private void jTextFieldidbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldidbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldidbukuActionPerformed

    private void jTextFieldcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcariKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox1.getSelectedItem();

            String searchTerm = jTextFieldcari.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT b FROM Buku b WHERE ";

            switch (selection.toLowerCase()) {
                case "idbuku":
                    queryString += "LOWER(b.idbuku) LIKE LOWER(:searchTerm)";
                    break;
                case "isbn":
                    queryString += "LOWER(b.isbn) LIKE LOWER(:searchTerm)";
                    break;
                case "judul":
                    queryString += "LOWER(b.judul) LIKE LOWER(:searchTerm)";
                    break;
                case "kategori":
                    queryString += "LOWER(b.kategori) LIKE LOWER(:searchTerm)";
                    break;
                case "pengarang":
                    queryString += "LOWER(b.pengarang) LIKE LOWER(:searchTerm)";
                    break;
                case "penerbit":
                    queryString += "LOWER(b.penerbit) LIKE LOWER(:searchTerm)";
                    break;
                case "tahun":
                    queryString += "LOWER(b.tahun) LIKE LOWER(:searchTerm)";
                    break;
                case "jumlah halaman":
                    queryString += "LOWER(b.jumlahhalaman) LIKE LOWER(:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Create and execute the JPA query
            EntityManager em = null;

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("UASPU");
                em = emf.createEntityManager();

                TypedQuery<Buku> query = em.createQuery(queryString, Buku.class);
                query.setParameter("searchTerm", "%" + searchTerm + "%");

                List<Buku> results = query.getResultList();

                DefaultTableModel dataModel = new DefaultTableModel();

                // Add columns to the model
                dataModel.addColumn("ID BUKU");
                dataModel.addColumn("ISBN");
                dataModel.addColumn("JUDUL");
                dataModel.addColumn("KATEGORI");
                dataModel.addColumn("PENGARANG");
                dataModel.addColumn("PENERBIT");
                dataModel.addColumn("TAHUN");
                dataModel.addColumn("HALAMAN");
                // ... tambahkan kolom lain sesuai kebutuhan

                // Add rows to the model
                for (Buku result : results) {
                    Object[] rowData = {
                        result.getIdbuku(),
                        result.getIsbn(),
                        result.getJudul(),
                        result.getKategori(),
                        result.getPengarang(),
                        result.getPenerbit(),
                        result.getTahun(),
                        result.getJumlahhalaman(),};
                    dataModel.addRow(rowData);
                }

                // Set jTableBuku with the created model
                jTable2.setModel(dataModel);

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

    }//GEN-LAST:event_jTextFieldcariKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        jDialog1.setVisible(true);
        jDialog1.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.rowAtPoint(evt.getPoint());
        String idbuku = jTable2.getValueAt(baris, 0).toString();
        jTextFieldidbuku.setText(idbuku);

        String judul = jTable2.getValueAt(baris, 2).toString();
        jTextFieldjudul.setText(judul);

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahPeminjamanBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDatekembali;
    private com.toedter.calendar.JDateChooser jDatepinjam;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldangkatan;
    private javax.swing.JTextField jTextFieldcari;
    private javax.swing.JTextField jTextFieldid;
    private javax.swing.JTextField jTextFieldidbuku;
    private javax.swing.JTextField jTextFieldjudul;
    private javax.swing.JTextField jTextFieldnama;
    private javax.swing.JTextField jTextFieldnim;
    private javax.swing.JTextField jTextFieldprodi;
    // End of variables declaration//GEN-END:variables
}
