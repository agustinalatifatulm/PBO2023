/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan2PBO;

/**
 *
 * @author HP
 */
public class Reptil extends Karnivora {
    protected int Tinggi;
    protected char jumlahPopulasi;
    protected String makanan;
    private double BeratHewan;
    private String nama;
    /**
     * @return the Buaya
     */
    public Reptil(){
        this.makanan="Empal";
        this.Tinggi=128;
        this.jumlahPopulasi=60;
    }
    public Reptil(String makanan, int Tinggi, char jumlahPopulasi){
        this.makanan="Empal";
        this.Tinggi=128;
        this.jumlahPopulasi=60;
    }

    /**
     * @return the BeratHewan
     */
    public double getBeratHewan() {
        return BeratHewan;
    }

    /**
     * @param BeratHewan the BeratHewan to set
     */
    public void setBeratHewan(double BeratHewan) {
        this.BeratHewan = 21;
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
