package supermercadoLopez;

import ejercicios.linkedlist.src.estdatos.linkedlists.*;

public class MyLinkedList<E> {

    // Ojo, el apuntador a la cabeza de la lista nunca
    // debe moverse, de lo contrario perderá la referencia
    // al primer elemento.
    private NodoCola<E> head;
    private int size = 0; // Number of elements in the list

    public void imprimirMayores(E valor) {
        // Recorre cada nodo

        NodoCola<E> p = head;

        while (p != null) {

            if (valor instanceof String) {

                String valorNodo = (String) p.getData();

                if (valorNodo.compareTo((String) valor) > 0) {
                    System.out.println(valorNodo + " - ");
                }

            } else if (valor instanceof Integer) {

                int eValor = (Integer) valor;
                int eNodo = (Integer) p.getData();

                if (eNodo > eValor) {
                    System.out.println(eNodo + " - ");
                }

            } else {

                Comparable c = (Comparable) p.getData();

                if (c.compareTo((Comparable) valor) > 0) {
                    System.out.println(p.getData() + " - ");
                }

            }

            p = p.getNext();

        }

    }

    public int getSize() {
        return size;
    }

    /**
     * Agrega un elemento ordenandolo
     *
     */
    /**
     * Agrega un elemento de tipo E a la lista
     *
     * @param e
     */
    public void add(E element) {

        if (head == null) {
            // Si la lista está vacía, la cabeza será el nodo que se creará
            head = new NodoCola<E>(element);
            size++;
            // Se incluye return para que finalice el método
            return;
        }

        // Y si no está vacía?
        // Variable temporal apuntando a la cabeza
        NodoCola<E> current = head;

        // Recorro la lista moviendo el apuntador
        while (current.getNext() != null) {
            current = current.getNext();
        }

        // Cuando se encuentra el último nodo, es decir, 
        // el nodo sin un nodo siguiente, entonces 
        // se crea el nuevo nodo asignándolo como current
        current.setNext(new NodoCola<E>(element));
        size++;

    }

    /**
     * Imprime la lista completa.
     *
     * @return String con la información de los elementos contenidos
     */
    public String print() {
        // Se crea un objeto que guardará el resultado
        // de la concatenación. Se podría haber usado un
        // String también.
        StringBuffer sb = new StringBuffer("");

        if (!isEmpty()) {
            NodoCola<E> current = head;
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(current.getData());
                current = current.getNext();
                if (current != null) {
                    sb.append(", ");
                } else {
                    sb.append("]");
                }
            }

        } else {
            sb.append("No se puede imprimir, la lista se encuentra vacia");
        }
        return sb.toString();
    }

    /**
     * Busca un elemento dentro de una lista, y lo elimina.
     */
    public void removeElement(E element) {
        // TODO Considerar los posibles casos
        // 1) Si el elemento a borrar está en la cabeza
        // 2) Si el elemento a borrar está en la mitad
        // 3) Si el elemento a borrar está en la cola

        // ---------------------------
        // Se considera el caso (2)
        // ---------------------------
        // Se pregunta si hay un elemento luego de la cabeza
        if (!isEmpty()) {
            if (head.getNext() != null) {

                NodoCola<E> previous = head;

                while (previous.getNext() != null) {

                    NodoCola<E> toFind = previous.getNext();

                    if (!element.equals(toFind.getData())) {
                        previous = toFind;
                    } else {
                        NodoCola<E> current = toFind.getNext();
                        previous.setNext(current);
                        size--;
                        return;
                        // ¿Qué pasa con la relación que queda del 
                        // nodo a eliminar y el nodo que le sigue? 
                    }

                }

            }

            // ---------------------------
            // Se considera el caso (1)
            // ---------------------------
            if (head.getData().equals(element)) {

                if (head.getNext() != null) {

                    head = head.getNext();
                    size--;
                } else {
                    head = null;
                    size--;
                }
            }
        }

        // ---------------------------
        // Se considera el caso (3)
        // ---------------------------
    }

    // *************************************
    // METODOS PARA IMPLEMENTAR POR LOS
    // ESTUDIANTES
    // *************************************
    public E get(int pos) {
        if (!isEmpty()) {
            if (pos < size) {
                NodoCola<E> p = head;

                for (int i = 0; i < pos; i++) {
                    p = p.getNext();
                }
                return p.getData();
            }

        } else {
            return null;
        }
        return null;
    }

    /**
     *
     * @param element
     * @param pos
     */
    public void add(E element, int pos) {
        if (!isEmpty()) {
            if (pos < size + 1) {
                NodoCola<E> nodoNuevo = new NodoCola(element);
                NodoCola<E> temp = head;

                //Si la posición ingresada es 0
                if (pos == 0) {
                    nodoNuevo.setNext(temp);
                    head = nodoNuevo;
                    size++;
                } else if (pos > 0) {

                    NodoCola<E> nodoAnt = head;

                    for (int i = 0; i < pos; i++) {
                        temp = temp.getNext();
                    }

                    for (int j = 0; j < pos - 1; j++) {
                        nodoAnt = nodoAnt.getNext();
                    }

                    nodoNuevo.setNext(temp);
                    nodoAnt.setNext(nodoNuevo);
                    size++;
                }
            }
        } else if (pos == 0) {
            NodoCola<E> nodoNuevo = new NodoCola(element);

            head = nodoNuevo;
            size++;
        }
    }

    /**
     *
     * @param pos
     * @return
     */
    public E remove(int pos) throws Exception {

//        int[] arreglo = new int[3];
//        arreglo[6] = 4;
        if (pos >= size) {
            throw new Exception("La posición no puede ser mayor a " + size);
        } else if (!isEmpty()) {
            if (pos < size) {
                NodoCola<E> temp = head;
                //Cuando se desea eliminar la cabeza
                if (pos == 0) {
                    head = temp.getNext();
                    size--;
                } else if (pos > 0) {
                    NodoCola<E> nodoAnt = head;

                    for (int i = 0; i < pos; i++) {
                        temp = temp.getNext();
                    }

                    for (int j = 0; j < pos - 1; j++) {
                        nodoAnt = nodoAnt.getNext();
                    }

                    nodoAnt.setNext(temp.getNext());
                    size--;
                }
            }
        }

        return null;
    }

    /**
     *
     */
    public void clear() {
        size = 0;
        head = null;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {

        return head == null && size == 0;
    }

    /**
     *
     * @return
     */
    public E getFirst() throws Exception {
        if (!isEmpty()) {
            return head.getData();
        }

        throw new Exception("La lista está vacía");

    }

    /**
     *
     * @param n1
     * @param n2
     */
    public void exchangeNodes(E dataNodeToFind, E dataNodeToInsert) {

        if (!isEmpty()) {
            NodoCola<E> temp = head;
            NodoCola<E> cambiarNodo = new NodoCola(dataNodeToInsert);

            if (head.getData().equals(dataNodeToFind)) {
                cambiarNodo.setNext(temp.getNext());
                head = cambiarNodo;
            } else {
                NodoCola<E> nodoAnt = head;

                int cont = 0;

                while (!temp.getData().equals(dataNodeToFind)) {
                    temp = temp.getNext();
                    cont++;
                }

                for (int i = 0; i < cont - 1; i++) {
                    nodoAnt = nodoAnt.getNext();

                }

                cambiarNodo.setNext(temp.getNext());
                nodoAnt.setNext(cambiarNodo);
            }

        }
    }

    
//    public void addN(E element, int pos){
//        Node<E> p =head;
//        p = head.getNext();
//        for (int i = 0; i < size; i++) {
//            Node<E> q = p.getNext();
//            if(i==pos){
//                Node<E> nuevoNodo = new Node<E>(element);
//                q.setNext(nuevoNodo.getNext());
//                nuevoNodo.setNext(p);
//                size++;
//                return;
//            }
//            
//        }
//    }
    public E removeObj(E element) {

        if (!isEmpty()) {

            if (head.getData().equals(element)) {
                head = head.getNext();
                size--;
            } else {
                NodoCola<E> temp = head;

                NodoCola<E> nodoAnt = head;

                int cont = 0;

                while (!temp.getData().equals(element)) {
                    temp = temp.getNext();
                    cont++;
                }

                for (int i = 0; i < cont - 1; i++) {
                    nodoAnt = nodoAnt.getNext();

                }
                
                nodoAnt.setNext(temp.getNext());
                size--;
            }
        }

        return null;
    }

    public E searchNode(E element) {
        return null;
    }

    public void addOrdered(E element) {

    }

}
