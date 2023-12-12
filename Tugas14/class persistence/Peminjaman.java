/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "peminjaman")
@NamedQueries({
    @NamedQuery(name = "Peminjaman.findAll", query = "SELECT p FROM Peminjaman p"),
    @NamedQuery(name = "Peminjaman.findByIdpeminjaman", query = "SELECT p FROM Peminjaman p WHERE p.idpeminjaman = :idpeminjaman"),
    @NamedQuery(name = "Peminjaman.findByNama", query = "SELECT p FROM Peminjaman p WHERE p.nama = :nama"),
    @NamedQuery(name = "Peminjaman.findByNim", query = "SELECT p FROM Peminjaman p WHERE p.nim = :nim"),
    @NamedQuery(name = "Peminjaman.findByProdi", query = "SELECT p FROM Peminjaman p WHERE p.prodi = :prodi"),
    @NamedQuery(name = "Peminjaman.findByTanggalpinjam", query = "SELECT p FROM Peminjaman p WHERE p.tanggalpinjam = :tanggalpinjam"),
    @NamedQuery(name = "Peminjaman.findByTanggalkembali", query = "SELECT p FROM Peminjaman p WHERE p.tanggalkembali = :tanggalkembali"),
    @NamedQuery(name = "Peminjaman.findByAngkatan", query = "SELECT p FROM Peminjaman p WHERE p.angkatan = :angkatan"),
    @NamedQuery(name = "Peminjaman.findByJudulbuku", query = "SELECT p FROM Peminjaman p WHERE p.judulbuku = :judulbuku"),
       @NamedQuery(name = "Peminjaman.findByidbuku", query = "SELECT p FROM Peminjaman p WHERE p.idbuku.idbuku = :idbuku")})
public class Peminjaman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpeminjaman")
    private String idpeminjaman;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nim")
    private String nim;
    @Column(name = "prodi")
    private String prodi;
    @Column(name = "tanggalpinjam")
    @Temporal(TemporalType.DATE)
    private Date tanggalpinjam;
    @Column(name = "tanggalkembali")
    @Temporal(TemporalType.DATE)
    private Date tanggalkembali;
    @Column(name = "angkatan")
    private String angkatan;
    @Column(name = "judulbuku")
    private String judulbuku;
    @JoinColumn(name = "idbuku", referencedColumnName = "idbuku")
    @ManyToOne
    private Buku idbuku;

    public Peminjaman() {
    }

    public Peminjaman(String idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public String getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(String idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public Date getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(Date tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public Date getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(Date tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public Buku getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(Buku idbuku) {
        this.idbuku = idbuku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpeminjaman != null ? idpeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peminjaman)) {
            return false;
        }
        Peminjaman other = (Peminjaman) object;
        if ((this.idpeminjaman == null && other.idpeminjaman != null) || (this.idpeminjaman != null && !this.idpeminjaman.equals(other.idpeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uas.Peminjaman[ idpeminjaman=" + idpeminjaman + " ]";
    }
    
}
