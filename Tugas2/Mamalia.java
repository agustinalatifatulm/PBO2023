/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class Mamalia extends Karnivora {

   protected int Tinggi;
    protected char jumlahPopulasi;
    protected String makanan;
     private String ciriKhusus;
     private String Nama;
    /**
     * @return the namaMamalia
     */
    public Mamalia(){
        this.Nama = "Harimau";
        this.makanan="Hewan lain";
        this.Tinggi=128;
        this.jumlahPopulasi=60;
        
    }
    public Mamalia( String Nama,String makanan, int Tinggi, char jumlahPopulasi){
        this.Nama = "Harimau";
        this.makanan="Hewan lain";
        this.Tinggi=128;
        this.jumlahPopulasi=60;
        
    }

    /**
     * @return the ciriKhusus
     */
    public String getCiriKhusus() {
        return ciriKhusus;
    }

    /**
     * @param ciriKhusus the ciriKhusus to set
     */
    public void setCiriKhusus(String ciriKhusus) {
        this.ciriKhusus = ciriKhusus;
    }

    /**
     * @return the Nama
     */
    public String getNama() {
        return Nama;
    }
    

    /**
     * @return the tinggiTubuh
     */
   

    /**
     * @return the jumlahPopulasi
     */
    
}
