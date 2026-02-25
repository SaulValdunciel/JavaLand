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
    
    //array para guardar niveles de monstruos
    private Monstruo[] Monstruo = new Monstruo[10];  //maximo 10
    private int contador = 0;
    
    //Constructor vacio
    public GestorMostruos(){  
    }
    
    @Override
    public void crear() {
        
    }

   // monstruo con estadisticas segun el nivel (lo año de lista)
    public void GenerarMonstruo(int nivel){
        if (contador < Monstruo.length){
            int vida = 40 + nivel;
            int fuerza = 5 + nivel;
            int defensa = 5 + nivel;
            int habilidad = 5 + nivel;
            int velocidad = 5 + nivel;
            
            Monstruo[contador] = new Monstruo( 
                    "Monstruo nivel " + nivel,
                    vida, fuerza, defensa, habilidad, velocidad, nivel 
            );
            
            System.out.println("Monstruo creado de nivel: " + nivel);
            contador++;
            
        } else{
            System.out.println("No se pude crear más monstruos.");
        }
    } 
    
    //buscar el monstruo en el array del Monstruo 
    
    //cuando encontrar borrar
    //mover borrar que ganas --> objeto monstruo(eliminarMonstruo)
    public void eliminarMonstruo(Monstruo monstruo){
       int indice = -1;
       for(int i = 0; i < contador; i++){
           if (Monstruo[i].getNombre().equalsIgnoreCase(monstruo)){
               indice = i;
               break;
           }
       }
       // 3. Mover los elementos hacia la izquierda
        for (int i = indice; i < contador - 1; i++) {
            Monstruo[i] = Monstruo[i + 1];
        }
        Monstruo[contador - 1] = null;

          contador--;
    }
    // Mostrar todos los monstruos creados
    public void mostrarMonstruos() {
        if (contador == 0) {
            System.out.println("No hay monstruos creados.");
            return;
        }

        System.out.println("Lista de monstruos:");
        for (int i = 0; i < contador; i++) {
            System.out.println("- " + Monstruo[i].getNombre());
        }
    }
}
