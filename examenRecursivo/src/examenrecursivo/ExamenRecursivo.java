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
    
     // Método recursivo para obtener un número entero válido
    public static int obtenerEnteroValido(String mensaje) {
        System.out.print(mensaje);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
            scanner.next();
            return obtenerEnteroValido(mensaje);
        }
    }
    
    private static int sumaInternaRecursiva(int i, int total, int [] arreglo){
        if(-1 == i){
            return total;
        }
        return sumaInternaRecursiva(i-1, total+arreglo[i], arreglo);
    }
    public static void sumaArregloRecursiva(int [] arreglo){
        int resultado = sumaInternaRecursiva(arreglo.length-1, 0, arreglo);
        System.out.println("");
        System.out.println("El resultado del ejercicio 1: ");
        System.out.println("");
        System.out.println("La suma del arreglo es: "+ resultado);
    }
    
      // Función recursiva para llenar el arreglo
    public static void llenarArreglo(Scanner scanner, int[] arreglo, int i) {
        if (i < arreglo.length) {
            arreglo[i] = obtenerEnteroValido("Ingresa el elemento en la posición " + i + ": ");
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
        int tamaño = obtenerEnteroValido("Ingresa el tamaño del arreglo: ");
        int[] arreglo = new int[tamaño];
         //Llamada inicial a la función recursiva para llenar el arreglo
        llenarArreglo(scanner, arreglo, 0);
        
        //Llamada a la función recursiva para mostrar el arreglo
        System.out.println("");
        System.out.println("El arreglo es:");
        mostrarArreglo(arreglo, 0);
        sumaArregloRecursiva(arreglo);
    }
    
    
    //2 ejercicio 
    
    public static void ejercicio2(){
        ListaCircular lista = new ListaCircular();
        System.out.println("");
        System.out.println("Resultado ejercicio 2: ");
        System.out.println("");
        lista.agregar("hola");
        lista.agregar("argentina");
        lista.agregar("es");
        lista.agregar("campeon");
        lista.agregar("MESSI");
        lista.agregar("ye ye");
        lista.imprimirLista();
        System.out.println("");
    }
    
    public static void ingresarValoresEjercicio3(){
        System.out.println("");
        System.out.println("El ejercicio 3: 1");
        System.out.println("");
        int tamaño = obtenerEnteroValido("Ingrese la cantidad de valores que desea ingresar: ");
        Pila pila = new Pila();
        pila = ingresarValor(0, tamaño, pila);
        System.out.println("El resultado del ejercicio 3: ");
        System.out.println("");
        pila.imprimirInvertido();
    }
    
    public static Pila ingresarValor(int i, int tamaño, Pila pila){
        if(i < tamaño){
            System.out.println("Ingrese el valor: ");
            String valor = scanner.next();
            pila.apilar(valor);
            return ingresarValor(i+1, tamaño, pila);
        }
        else{
            return pila;
        }
    }
    
    public static void ejercicio3(){
        
        ingresarValoresEjercicio3();
    }
    
    
    public static int potencia(int b, int c){
        return calculoPotencia(b, c, 0, 1);
    }
    
    private static int calculoPotencia(int b, int c, int i, int total){
        if(i < c){
            total *= b;
            return calculoPotencia(b, c, i+1, total);
        }
        else{
            return total;
        }
    }
    
    public static int factorial(int a){
        return calculoFactorial(a, 1,1);
    }
    
    private static int calculoFactorial(int a, int i, int total){
        if(i <= a){
            total *= i;
            return calculoFactorial(a, i+1, total);
        }
        else{
            return total;
        }
    }
            
    public static int multiplicacion(int a, int b){
        return a * b;
    }
    
    
    public static void ejercicio4(){
        System.out.println("");
        System.out.println("Ejercicio 4:");
        int factorial = obtenerEnteroValido("Ingrese el numero para sacarle el factorial: "); 
        int base = obtenerEnteroValido("Ingrese el numero base para calcular: ");
        int potencia = obtenerEnteroValido("Ingrese el numero de la potencia para calcular: ");
        
        int a = factorial(factorial);
        System.out.println("El valor de A (numero factorial) de " + factorial + " es "+ a);
        int b = potencia(base, potencia);
        System.out.println("El valor de B (base) " + base + "(potencia) " + potencia + " es " +b);
        System.out.println("Resultado:");
        System.out.println("A * B: " +multiplicacion(a, b));
    }
    
    
    
    public static void menu(){
        String opcion;
        System.out.println("");
        System.out.println("Menu de ejercicios");
        System.out.println("");
        System.out.println("1: Suma de valores");
        System.out.println("2: Lista circular concatenada");
        System.out.println("3: Pila impresa invertida");
        System.out.println("4: Multiplicacion de dos valores");
        System.out.println("5: Salir");
        System.out.println("");
        opcion = scanner.next();
         switch (opcion) {
                case "1":
                    ingresarArreglo();
                    menu();
                    break;
                case "2": 
                    ejercicio2(); 
                    menu();
                    break; 
                case "3":
                    ejercicio3(); 
                    menu(); 
                    break; 
                case "4": 
                    ejercicio4(); 
                    menu(); 
                    break; 
                case "5":
                    System.out.println("bye");
                    break;
            default:
                    System.out.println("Opción no valida. Por favor, intente de nuevo.");
                    menu();
                    break;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       menu();
        
    }
    
}
