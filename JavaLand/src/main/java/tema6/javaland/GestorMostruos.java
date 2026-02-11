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
    private int[] monstruo = new int[10];  //maximo 10
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
        if (contador < monstruo.length){
            monstruo[contador] = nivel;
            System.out.println("Monstruo creado de nivel: " + nivel);
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