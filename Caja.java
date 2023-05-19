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
    private int idCaja;
    private int totalFacturado;

    public Caja() {
    }

    public Caja(int idCaja, int totalFacturado) {
        this.idCaja = idCaja;
        this.totalFacturado = totalFacturado;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(int totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
    
    public String toString(){
        return ""+getTotalFacturado();
    }
}
