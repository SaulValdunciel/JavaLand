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
public class GestorValientes implements GestoresInterface {
    //array para guardar nombres de valientes
    private String[] valientes = new String[4];      
      
      //constructor
      public GestorValientes(){
          
      }
      
    @Override
    public void crear() {
         crearValientes();
    }
    
    // Crear los 4 valientes iniciales 
    //cada uno tiene 40 puntos repartidos entre fuerza, defensa, habilidad, velocidad.
    private void crearValientes() {
            // Guerrero → destaca fuerza
            valientes[0] = "Guerrero (15, 10, 7, 8)";
            // Paladín → destaca defensa
            valientes[1] = "defensa (8, 15, 7, 10)";
            // Mago → destaca habilidad
            valientes[2] = "habilidad (7, 8, 17, 8)";
            // Pícaro → destaca velocidad
            valientes[3] = "Picaro (8, 7, 10, 15)";
            
        System.out.println("Valientes creados correctamente.");
    }        
}
