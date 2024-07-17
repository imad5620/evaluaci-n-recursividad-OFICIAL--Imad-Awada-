/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrecursivo;

/**
 *
 * @author imad
 */
public class ListaCircular {
    
     private static class Nodo {
        private String palabra;
        private Nodo siguiente;

        Nodo(String palabra) {
            this.palabra = palabra;
            this.siguiente = null;
        }
    }
     
    private Nodo cola;
    private int tamaño;

    public ListaCircular() {
        cola = null;
        tamaño = 0;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Método para obtener el tamaño de la lista
    public int tamaño() {
        return tamaño;
    }

    // Método para agregar un elemento al final de la lista
    public void agregar(String palabra) {
        Nodo nuevoNodo = new Nodo(palabra);
        if (estaVacia()) {
            nuevoNodo.siguiente = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cola.siguiente;
            cola.siguiente = nuevoNodo;
            cola = nuevoNodo;
        }
        tamaño++;
    }

    // Método para imprimir los elementos de la lista
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo actual = cola.siguiente;
        mostrarLista(actual, cola);
    }
    
    private void mostrarLista(Nodo actual, Nodo cola){
        System.out.print(actual.palabra + " ");
        if(actual != cola){
            mostrarLista(actual.siguiente, cola);
        }
    }
    
}
