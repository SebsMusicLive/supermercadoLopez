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
//    private int clientes = 1;
    private int idCliente = 0;
    private int id = 0;
    
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
    
    public void añadirClientes(ColaLista<Object> clientesAñ){
        Cliente c1 = new Cliente(idCliente++, nombreRandomCliente());
        
        clientesAñ.insertar(c1);
        
//       clientesAñ.insertar(clientes++);
    }
    
    public String nombreRandomCliente(){
        String nombre = "Cliente ";

        return nombre+=id++;
    }
    
    public String mostrarCarritos(ColaArray<Integer> colaCarritos){
        return colaCarritos.print(); 
    }
    
    
    
    
}
