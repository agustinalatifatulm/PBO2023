/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Latihan3PBO;

/**
 *
 * @author HP
 */
public class OrangKristen extends Orang{
    private String tempatIbadah;
    
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
        this.tempatIbadah = "Gereja";
    }
    public OrangKristen(){
        this.tempatIbadah="gereja";
    }
    
}
