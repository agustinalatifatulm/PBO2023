/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class Output {
    public static void main(String[] args) {
        Hewani macan = new Hewani();
        
        macan.setNama("Macan");
        macan.setKlasifikasi("Mamalia");
        macan.setJumlahKaki(4);
        Karnivora Singa =new Karnivora();
        Singa.setNama("Singa");
        Singa.setKlasifikasiKarnivora("Mamalia");
        Reptil ular= new Reptil();
        ular.setBeratHewan(5);
       
        ular.setNama("Ular");
        Mamalia Harimau =new Mamalia();
        Harimau.setCiriKhusus("Memiliki puting susu");
        
        
        System.out.println("Hewan " + macan.getNama() + " Termasuk kedalam klasifikasi " + macan.getKlasifikasi() + " Memiliki jumlah kaki " + macan.getJumlahKaki());
        System.out.println("Hewan " + Singa.getNama()+ " adalah hewan pemakan" + Singa.getmakanan() + " Dengan tinggi badan = " + Singa.Tinggi + " Singa termasuk kedalam jenis klasifikasi " + Singa.getKlasifikasiKarnivora());
        System.out.println("Hewan " +ular.getNama() + " dengan berat " + ular.getBeratHewan()+" adalah salah satu contoh reptilia pemakan " + ular.makanan);
        System.out.println("Hewan " + Harimau.getNama() + " Adalah hewan pemakan " + Harimau.getmakanan() + " dan memiliki tinggi sekitar " + Harimau.getTinggi() + " Termasuk kedalam klasifikasi mamalia dengan ciri khusus  " +Harimau.getCiriKhusus());
       
        
        
        
    }
    public void setSinga(boolean Singa){
        this.setSinga(Singa); 
    }
    public void setUlar(boolean Ular){
        this.setUlar(Ular);
        
    }
    
    
}
