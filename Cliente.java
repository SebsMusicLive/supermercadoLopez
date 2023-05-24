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
     private MyLinkedList<Producto> producto = new MyLinkedList<>();
     private boolean esSocio;
   

    public Cliente() {
    }

    public Cliente(int cedula, String nombre, MyLinkedList producto, boolean esSocio) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.producto = producto;
        this.esSocio = esSocio;
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

    public MyLinkedList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(MyLinkedList<Producto> producto) {
        this.producto = producto;
    }

    public boolean isEsSocio() {
        return esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }
    
    
    @Override
    public String toString(){
        String socio="";
        if(isEsSocio()){
            //Si es socio se le asigna una X
            socio="X";
        }else{
            //Si no es socio se le asigna un 0
            socio="0";
        }
        return "Cédula: "+ this.getCedula() + "\n Nombre: "+this.getNombre()+ "\n Socio: "+socio;
    }
}
