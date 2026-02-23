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
    
    //array para guarfar niveles de monstruos
    private Monstruo[] Monstruo = new Monstruo[10];  //maximo 10
    private int contador = 0;
    
    //Constructor vacio
    public GestorMostruos(){  
    }
    @Override
    public void crear() {
        crearMostruos();
    }

   // monstruo con estadisticas segun el nivel (lo año de lista)
    public void GenerarMonstruo(int nivel){
        if (contador < Monstruo.length){
            int vida = 40 + nivel * 10;
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
    //Eliminar el ultimo monstruo creado
    public void eliminarMonstruo(){
        if (contador > 0) {
            contador--;
            System.out.println("Monstruo eliminado.");
        } else {
            System.out.println("No hay monstruos para eliminar");
        }
    }

    private void crearMostruos() {
    }
}
