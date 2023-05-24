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
    private Producto product = new Producto();
    private MyLinkedList<Producto> productosDisp = new MyLinkedList<>();
//    private MyLinkedList<Producto> productoCliente = new MyLinkedList<>();

    public Supermercado() {
        product = new Producto(1, "Arroz", 3200);
        productosDisp.add(product);
        product = new Producto(2, "Panela", 2000);
        productosDisp.add(product);
        product = new Producto(3, "Azucar", 3000);
        productosDisp.add(product);
        product = new Producto(4, "Sal", 1500);
        productosDisp.add(product);
        product = new Producto(5, "Aceite", 5000);
        productosDisp.add(product);
        product = new Producto(6, "Harina Pan", 4000);
        productosDisp.add(product);
        product = new Producto(7, "Mayonesa Natucampo", 4000);
        productosDisp.add(product);
        product = new Producto(8, "Salsa de tomate Natucampo", 5000);
        productosDisp.add(product);
        product = new Producto(9, "Salsa Negra", 3000);
        productosDisp.add(product);
        product = new Producto(10, "Harina de Trigo", 4000);
        productosDisp.add(product);
    }
    
    
    public Supermercado(ColaArray<Integer> colaCarritos){
        
        
        colaCarritos.crearCola(25);
    }
    
    public Supermercado(ColaArray<Cliente> pagoCaja1, ColaArray<Cliente> pagoCaja2, ColaArray<Cliente> pagoCaja3){
        
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
    
    public void añadirClientes(ColaLista<Cliente> clientesAñ, int cedula, String nombre) throws Exception{
        int socio = (int)(Math.random()*10 + 1);
        Cliente c1 = new Cliente(cedula, nombre, productoComprado(), clienteSocio(socio));   
        clientesAñ.insertar(c1);
    }
    
    public void añadirClientesAleatorios(ColaLista<Cliente> clientesAñ) throws Exception{
        int socio = (int)(Math.random()*10 + 1);
        Cliente c1 = new Cliente((int)(Math.random()*1000000900 + 1), "Cliente "+numeroCliente++, productoComprado(), clienteSocio(socio));
        clientesAñ.insertar(c1);
    }
    
    public boolean clienteSocio(int socio){
        //Es socio quien tenga el valor de uno
        return socio<3;
    }
    
    public MyLinkedList<Producto> productoComprado() throws Exception{
        int cantProductos = (int) (Math.random() * 10 + 1);
        MyLinkedList<Producto> productoCliente = new MyLinkedList<>();
        
        while(cantProductos-- >0){
            int producto = (int) (Math.random() * 10 + 1);
            if (producto >= productosDisp.getSize()) {
                producto--;
            }
            productoCliente.add(productosDisp.get(producto));
        }
        
        return productoCliente;
    }   
    
    public String mostrarClientesAtendidos(MyLinkedList<Caja> caja) throws Exception{
        String rta="", nombre = "", nombreAnterior = "";
        int totalFacturado=0;

        for (int i = 0; i < caja.getSize(); i++) {
            totalFacturado+=caja.get(i).getTotalFacturado();
            nombre = caja.get(i).getNombre();
            if(i>0){
                nombreAnterior = caja.get(i-1).getNombre();
            }
            
            if(!nombre.equals(nombreAnterior)){
                rta += nombre + " |  "+totalFacturado+"\n";
            }
            
        }
        
        return rta;
    }
    
    public String mostrarCarritos(ColaArray<Integer> colaCarritos){
        return colaCarritos.print(); 
    }
    
    public String mostrarClientes(ColaLista<Cliente> clientes){
        return clientes.print();
    }
    
    public int precioTotal(MyLinkedList<Caja> precio) throws Exception{
        int resultado = 0;
        
        for (int i = 0; i < precio.getSize(); i++) {
            resultado = precio.get(i).getTotalFacturado();
            
        }
        return resultado;
    }
    
    public String mostrarProductos(){
        return productosDisp.printProducto();
    }
    
    
}
