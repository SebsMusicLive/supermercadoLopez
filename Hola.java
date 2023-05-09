/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadoLopez;

/**
 *
 * @author ASUS
 */
public class Hola {
    public static void main(String[] args) throws Exception {
        ColaArray<Integer> mi = new ColaArray<>();
        
        mi.crearCola(2);
        
        mi.insertar(2);
        mi.insertar(3);
        
        System.out.println(mi.quitar());
        
        System.out.println(mi.print());
        System.out.println(mi.quitar());
        
        
    }
}
