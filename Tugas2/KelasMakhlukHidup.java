/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class KelasMakhlukHidup {
    private String klasifikasi;
    protected int Tinggi;
    protected char jumlahPopulasi;
    protected String makanan;
    
    
    
    public KelasMakhlukHidup(){
        this.makanan = "Daging";
        this.Tinggi = 28;
        this.jumlahPopulasi = 60;
    }
    
    public KelasMakhlukHidup(String makanan){
        this.makanan = makanan;
        this.Tinggi = 28;
        this.jumlahPopulasi= 60;
    }
    public KelasMakhlukHidup(int Tinggi){
        this.makanan = "Daging";
        this.Tinggi = Tinggi;
        this.jumlahPopulasi= 60;
    }
    
    public KelasMakhlukHidup(char jumlahPopulasi){
        this.makanan ="Daging";
        this.Tinggi = 28;
        this.jumlahPopulasi= jumlahPopulasi;
    }

    /**
     * @return the klasifikasi
     */
    public String getmakanan() {
        return makanan;
    }

    public String getKlasifikasi() {
        return klasifikasi;
    }

    /**
     * @param klasifikasi the klasifikasi to set
     */
    public void setKlasifikasi(String klasifikasi) {
        this.klasifikasi = klasifikasi;
    }

    /**
     * @return the alatPernapasan
     */
    

    /**
     * @return the caraReproduksi
     */
    
     
   
    
    
  
    
}
