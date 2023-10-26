/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LatihanInterface;

/**
 *
 * @author HP
 */
import Latihan3PBO.Orang;
import Latihan3PBO.OrangIslam;
import Latihan3PBO.OrangKristen;
      
public class jalanProgram {
    public static void main(String[] args) {
        
        System.out.println("Agama-agama diIndonesia sangat beragam");
        OrangIslam Ajib = new OrangIslam();
        System.out.println("Ajib adalah seorang muslim");
        System.out.println("Ajib berdomisili di " + Ajib.getDaerah());
        System.out.println("Ajib " + Ajib.beribadah(5) + " Kali sehari");
        Ajib.mondok();
        Ajib.mengajarSantri();
        Ajib.memimpinSholat();
        System.out.println("Selain islam, di Indonesia juga terdapat agama kristen ");
        System.out.println("                ");
        
        System.out.println("Contohnya, adalah seorang pendeta ");
     
        OrangKristen pendeta =new OrangKristen();
        System.out.println("Seorang pendeta " + pendeta.beribadah("Pagi"));
        System.out.println("pendeta beribadah di " + pendeta.getTempatIbadah());
        
        Orang umum = new Orang();
        System.out.println("Penduduk asli secara umum berasal dari daerah  " + umum.getDaerah());
        System.out.println("Secara umum orang akan tidur " + umum.beribadah(8)+ " jam sehari");
        
        
        
    }
   
}
