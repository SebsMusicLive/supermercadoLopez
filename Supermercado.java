/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadoLopez;

/**
 *
 * @author ASUS
 */
public class Supermercado {
    private int numeroCliente = 1;
    
    public Supermercado(ColaArray<Integer> colaCarritos){
        colaCarritos.crearCola(25);
    }
    
    public Supermercado(ColaArray<Object> pagoCaja1, ColaArray<Object> pagoCaja2, ColaArray<Object> pagoCaja3){
        
        pagoCaja1.crearCola(1);
        pagoCaja2.crearCola(1);
        pagoCaja3.crearCola(1);
    }
    
    public void llenarColaCarritos(ColaArray<Integer> colaCarritos) throws Exception{
        int carritos =1;
        for (int i = 0; i < colaCarritos.tamañoCola();i++) {
            colaCarritos.insertar(carritos++);
        }
    }
    
    public void añadirClientes(ColaLista<Object> clientesAñ, int cedula, String nombre){
        
        
        Cliente c1 = new Cliente(cedula, nombre);
        
        clientesAñ.insertar(c1);
        
//       clientesAñ.insertar(clientes++);
    }
    
    public void añadirClientesAleatorios(ColaLista<Object> clientesAñ){
        Cliente c1 = new Cliente((int)(Math.random()*1000000000 + 1), "Cliente "+numeroCliente++);
        
        clientesAñ.insertar(c1);
        
    }
    
    
    
    public String mostrarCarritos(ColaArray<Integer> colaCarritos){
        return colaCarritos.print(); 
    }
    
    
    
    
}
