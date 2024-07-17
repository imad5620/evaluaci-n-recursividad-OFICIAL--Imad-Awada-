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
public class Pila {
    
    private class Nodo {
        private String valor;
        private Nodo siguiente;

        public Nodo(String valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo cima;
    private int tamaño;

    public Pila() {
        cima = null;
        tamaño = 0;
    }

    public void apilar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamaño++;
    }
    
    public void imprimirInvertido(){
         if (estaVacia()) {
            System.out.println("La pila está vacía");
        } else {
            imprimirInvertidoRecursivo(cima);
            System.out.println();
        }
    }
    
    // Método recursivo para imprimir la pila en orden inverso
    private void imprimirInvertidoRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        imprimirInvertidoRecursivo(nodo.siguiente);
        System.out.print(nodo.valor + " ");
    }
    
    public String desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
        }
        String elemento = cima.valor;
        cima = cima.siguiente;
        tamaño--;
        return elemento;
    }


    public boolean estaVacia() {
        return cima == null;
    }

    public int obtenerTamaño() {
        return tamaño;
    }
}
