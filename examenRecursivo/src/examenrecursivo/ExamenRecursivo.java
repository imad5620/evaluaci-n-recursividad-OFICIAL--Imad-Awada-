/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenrecursivo;

import java.util.Scanner;

/**
 *
 * @author imad
 */
public class ExamenRecursivo {
    static Scanner scanner = new Scanner(System.in);
    
    private static int sumaInternaRecursiva(int i, int total, int [] arreglo){
        if(-1 == i){
            return total;
        }
        return sumaInternaRecursiva(i-1, total+arreglo[i], arreglo);
    }
    public static void sumaArregloRecursiva(int [] arreglo){
        int resultado = sumaInternaRecursiva(arreglo.length-1, 0, arreglo);
        System.out.println("");
        System.out.println("");
        System.out.println("La suma del arreglo es: "+ resultado);
    }
    
      // Función recursiva para llenar el arreglo
    public static void llenarArreglo(Scanner scanner, int[] arreglo, int i) {
        if (i < arreglo.length) {
            System.out.print("Ingresa el elemento en la posición " + i + ": ");
            arreglo[i] = scanner.nextInt();
            llenarArreglo(scanner, arreglo, i + 1);
        }
    }

    // Función recursiva para mostrar el arreglo
    public static void mostrarArreglo(int[] arreglo, int i) {
        if (i < arreglo.length) {
            System.out.print(arreglo[i] + " ");
            mostrarArreglo(arreglo, i + 1);
        }
       
    }
    
    public static void ingresarArreglo(){
        System.out.print("Ingresa el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();
        int[] arreglo = new int[tamaño];
         // Llamada inicial a la función recursiva para llenar el arreglo
        llenarArreglo(scanner, arreglo, 0);
        
        // Llamada a la función recursiva para mostrar el arreglo
        System.out.println("");
        System.out.println("El arreglo es:");
        mostrarArreglo(arreglo, 0);
        sumaArregloRecursiva(arreglo);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ingresarArreglo();
        
        
    }
    
}
