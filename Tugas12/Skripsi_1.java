/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "skripsi")
@NamedQueries({
    @NamedQuery(name = "Skripsi_1.findAll", query = "SELECT s FROM Skripsi_1 s"),
    @NamedQuery(name = "Skripsi_1.findByIdskripsi", query = "SELECT s FROM Skripsi_1 s WHERE s.idskripsi = :idskripsi"),
    @NamedQuery(name = "Skripsi_1.findByJudul", query = "SELECT s FROM Skripsi_1 s WHERE s.judul = :judul"),
    @NamedQuery(name = "Skripsi_1.findByPengarang", query = "SELECT s FROM Skripsi_1 s WHERE s.pengarang = :pengarang"),
    @NamedQuery(name = "Skripsi_1.findByTahun", query = "SELECT s FROM Skripsi_1 s WHERE s.tahun = :tahun"),
    @NamedQuery(name = "Skripsi_1.findByHalaman", query = "SELECT s FROM Skripsi_1 s WHERE s.halaman = :halaman")})
public class Skripsi_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idskripsi")
    private String idskripsi;
    @Column(name = "judul")
    private String judul;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "tahun")
    private String tahun;
    @Column(name = "halaman")
    private String halaman;

    public Skripsi_1() {
    }

    public Skripsi_1(String idskripsi) {
        this.idskripsi = idskripsi;
    }

    public String getIdskripsi() {
        return idskripsi;
    }

    public void setIdskripsi(String idskripsi) {
        this.idskripsi = idskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getHalaman() {
        return halaman;
    }

    public void setHalaman(String halaman) {
        this.halaman = halaman;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idskripsi != null ? idskripsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skripsi_1)) {
            return false;
        }
        Skripsi_1 other = (Skripsi_1) object;
        if ((this.idskripsi == null && other.idskripsi != null) || (this.idskripsi != null && !this.idskripsi.equals(other.idskripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uas.Skripsi_1[ idskripsi=" + idskripsi + " ]";
    }
    
}
