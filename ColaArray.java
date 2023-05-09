/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadoLopez;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ASUS
 */
public class ColaArray<E> implements Comparable<ColaArray<E>> {

    E cola[];
    int size = 0;

    public void crearCola(int tamaño) {
        cola = (E[]) new Object[tamaño];
        this.size = 0;
    }

    public void insertar(E elem) throws Exception {
        if (colaLlena()) {
            throw new Exception("Cola esta llena");
        }
        if (size < cola.length) {
            cola[size] = elem;
            size++;
        }
    }

    public E quitar() throws Exception {
        if (colaVacia() || size == 0) {
            throw new Exception("Cola esta Vacia");
        }
        E copia[] =  (E[]) new Object[cola.length];
        E primero = (E) cola[0];
        for (int i = 1; i < cola.length; i++) {
            copia[i - 1] = cola[i];
        }
        this.size--;
        cola = copia.clone();

        return primero;
    }

    public boolean colaVacia() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean colaLlena() {
        if (this.size == cola.length) {
            return true;
        } else {
            return false;
        }
    }

    public E frente() {
        return  cola[0];
    }

    public int tamañoCola(){
        return cola.length;
    }
    
    public int size() {
        return this.size;
    }

    public String print() {
        String datosCola = "";
        for (int i = 0; i < cola.length; i++) {
            if(cola[i] != null){
                datosCola += cola[i] + ";";
            }
        }
        return datosCola;
    }

    @Override
    public int compareTo(ColaArray<E> o) {
        int rta = -1;
        try {
            if (this.frente().equals(o.frente())) {
                rta = 0;
            } else {
                rta = 1;
            }
        } catch (Exception ex) {
            Logger.getLogger(ColaArray.class.getName()).log(Level.SEVERE, "No son comparables", ex);
        }
        return rta;

    }

}
