/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class Karnivora extends Hewani {
    private String klasifikasiKarnivora;
    protected int Tinggi;
    protected char jumlahPopulasi;
    protected String makanan;
    private String nama;
    

    /**
     * @return the klasifikasiKarnivora
     */
    public Karnivora(){
        this.makanan = "Hewan lain";
        this.jumlahPopulasi = 5;
        this.Tinggi= 138;
        
    }
    public Karnivora(String makanan,int Tinggi,char jumlahPopulasi){
        this.makanan = makanan;
        this.jumlahPopulasi= 5;
        this.Tinggi = 138;
    }
    
    public void keterangan(){
        System.out.println("klasifikasi Karnivora  "+ klasifikasiKarnivora);
        
    }
    public String getKlasifikasiKarnivora() {
        return klasifikasiKarnivora;
    }

    /**
     * @param klasifikasiKarnivora the klasifikasiKarnivora to set
     */
    public void setKlasifikasiKarnivora(String klasifikasiKarnivora) {
        this.klasifikasiKarnivora = klasifikasiKarnivora;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the Tinggi
     */
    public int getTinggi() {
        return Tinggi;
    }

    /**
     * @return the jumlahPopulasi
     */
    public char getJumlahPopulasi() {
        return jumlahPopulasi;
    }

}