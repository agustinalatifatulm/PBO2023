/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan3PBO;

/**
 *
 * @author HP
 */
public class OrangIslam extends Orang implements Imam,Santri, Ustadz{
    
    
    @Override
    public void mondok() {
        System.out.println("Sebagai santri di sebuah pondok pesantren, Ajib belajar setiap hari");
    }

    @Override
    public void memimpinSholat() {
        System.out.println("Dan sebagai seorang imam, Ajib memimpin sholat");
    }

    @Override
    public void mengajarSantri() {
        System.out.println("Sebagai salah seorang ustadz juga, Ajib juga turut mengajar para santri lainnya");
    }
    public void setDaerah(){
        super.setDaerah("Papua");
    }
    public OrangIslam(){
        this.setDaerah();
    }

    // Implementasi metode-metode lain dari kelas Orang atau metode yang dibutuhkan
}
