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
public class GestorMostruos implements GestoresInterface {
    GestorMostruos List = new GestorMostruos(); 
    
    //Constructor 
    public GestorMostruos(){ 
        
    }
        @Override
    public void crear() {
         System.out.println("Use generarMonstruos(int nivel) para crear monstruos.");
    }
     
    // monstruo con estadisticas segun el nivel (lo año de lista)
    private void crearMonstruo(int nivel) {
        int vida = 40 + nivel * 10;
        int fuerza = 5 + nivel;
        int defensa = 5 + nivel;
        int habilidad = 5 + nivel;
        int velocidad = 5 + nivel;

        Monstruo m = new Monstruo(
                "Monstruo Nv." + nivel,
                vida, fuerza, defensa, habilidad, velocidad, nivel
        );
        List.crear();
    } 
   /**
     * Elimina un monstruo de la lista cuando ha sido derrotado.
     */
    public void eliminarMonstruo(Monstruo m) {
        List.eliminarMonstruo(m);
    }   
}
