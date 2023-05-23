/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadoLopez;

/**
 *
 * @author ASUS
 */
public class Caja {

    private int totalFacturado;

    public Caja() {
    }

    public Caja(int totalFacturado) {

        this.totalFacturado = totalFacturado;
    }

    public int getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(int totalFacturado) {
        this.totalFacturado = totalFacturado;
    }

    public String toString() {
        return "" + getTotalFacturado();
    }
}
