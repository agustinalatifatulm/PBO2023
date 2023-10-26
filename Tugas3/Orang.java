/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan3PBO;

/**
 *
 * @author HP
 */
public class Orang {
    private String jenisMakanan;
    private String tempatIbadah;
    private String daerah;
    private String jenisBaju;
    public Orang(){
        this.daerah= "Indonesia";
    }
 
    
    
    
    public String beribadah(){
        return "sedang beribadah";
    }
    public String beribadah(String waktu){
        return "sedang beribadah " + "pada " + waktu;
    }
    public String beribadah(int waktu){
        return "beribadah " + " setiap " + String.valueOf(waktu);
    }
    public String beribadah(double waktu){
        return "sedang beribadah " + "pada pukul " + String.valueOf(waktu);
    }

    /**
     * @return the jenisMakanan
     */
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    /**
     * @param jenisMakanan the jenisMakanan to set
     */
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = "Tergantung dengan kepercayaan masing-masing";
    }

    /**
     * @return the tempatIbadah
     */
    public String getTempatIbadah() {
        return tempatIbadah;
    }

    /**
     * @param tempatIbadah the tempatIbadah to set
     */
    public void setTempatIbadah(String tempatIbadah) {
        this.tempatIbadah = "tempat ibadah";
    }

    /**
     * @return the daerah
     */
    public String getDaerah() {
        return daerah;
    }

    /**
     * @param daerah the daerah to set
     */
    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    /**
     * @return the jenisBaju
     */
    public String getJenisBaju() {
        return jenisBaju;
    }

    /**
     * @param jenisBaju the jenisBaju to set
     */
    public void setJenisBaju(String jenisBaju) {
        this.jenisBaju = "Ketentuan berdasarkan aturan agama masing-masing";
    }
    
}
