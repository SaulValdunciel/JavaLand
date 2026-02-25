/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Scanner;

/**
 *
 * @author cuent
 */
// Esta clase controla los valientes del juego
public class GestorValientes implements GestoresInterface {
    // Array para guardar nombres de valientes
    private Valiente[] valiente = new Valiente[4];
    private int contador = 0;

    @Override
    public void crear() {
        crearValientes();
    }
    
    //constructor de valores iniciales 
    public GestorValientes() {
    
    System.out.println("Valientes creados correctamente.");
    }

    private void crearValientes() {
        // metodo para crear 
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nombre del valiente: ");
        String nombre = scanner.nextLine();

        System.out.print("Fuerza (1-20): ");
        int fuerza = scanner.nextInt();

        System.out.print("Defensa (1-20): ");
        int defensa = scanner.nextInt();

        System.out.print("Habilidad (1-20): ");
        int habilidad = scanner.nextInt();

        System.out.print("Velocidad (1-20): ");
        int velocidad = scanner.nextInt();

        if (contador < valiente.length) {
            int vida = 0;
            valiente[contador] = new Valiente(nombre, vida, fuerza, defensa, habilidad, velocidad);
            System.out.println("Valiente creado correctamente.");
            contador++;
        } else {
            System.out.println("No se pueden crear más valientes.");
        }

    }
    
       public Valiente[] getValientes() {  //acceder a los valientes creados
           return valiente; 
       }
}
