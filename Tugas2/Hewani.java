/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class Hewani extends KelasMakhlukHidup {
    protected int Tinggi;
    protected char jumlahPopulasi;
    protected String makanan;
    private int jumlahKaki;
    private String nama;  

    /**
     * @return the nama
     */
    public Hewani(){
        super("Empal");
    }
    
    public Hewani(String makanan,int Tinggi,char jumlahPopulasi){
        super();
        this.makanan="Empal";
        this.Tinggi=128;
        this.jumlahPopulasi=60;
    }
    /**
     * @return the jumlahPopulasi
     */
    

    /**
     * @return the jumlahKaki
     */
    public int getJumlahKaki() {
        return jumlahKaki;
    }

    /**
     * @param jumlahKaki the jumlahKaki to set
     */
    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
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
    
}
