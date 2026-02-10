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

      private Crear list = new Crear();
      
      
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
            lista.add(new Valiente("Guerrero", 15, 10, 7, 8));
            
            // Paladín → destaca defensa
            lista.add(new Valiente("Paladín", 8, 15, 7, 10));
            
            // Mago → destaca habilidad
            lista.add(new Valiente("Mago", 7, 8, 17, 8));
            
            // Pícaro → destaca velocidad
            lista.add(new Valiente("Pícaro", 8, 7, 10, 15));
            
        System.out.println("Valientes creados correctamente.");
        return list;
    }        
}
