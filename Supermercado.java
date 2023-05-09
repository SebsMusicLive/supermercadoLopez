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
    private int clientes = 1;
    
    public Supermercado(ColaArray<Integer> colaCarritos){
        colaCarritos.crearCola(25);
    }
    
    public Supermercado(ColaArray<Integer> pagoCaja1, ColaArray<Integer> pagoCaja2, ColaArray<Integer> pagoCaja3){
        
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
    
    
    
    public void añadirClientes(ColaLista<Integer> clientesAñ){
        
        clientesAñ.insertar(clientes++);
    }
    
    public String mostrarCarritos(ColaArray<Integer> colaCarritos){
        return colaCarritos.print(); 
    }
    
    
    
    
}
