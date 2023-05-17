/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadoLopez;

/**
 *
 * @author ASUS
 */
public class Cliente {
    private int cedula;
    private String nombre;
   

    public Cliente() {
    }

    public Cliente(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int idCliente) {
        this.cedula = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        
        return "Cédula: "+ this.getCedula() + "\n Nombre: "+this.getNombre();
    }
}
