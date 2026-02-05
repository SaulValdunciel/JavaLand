/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author cuent
 */
public class GestorMostruos {
       
    ArrayList arrayList = new ArrayList(); 

    //Constructor 
    public GestorMostruos(){  
    }
    // monstruo con estadisticas segun el nivel (lo año de lista)
    public Monstruo GenerarMonstruo(int nivel){
        int vida = 40 + nivel + nivel *10;
        int fuerza = 10 + nivel;
        int defensa = 10 + nivel;
        int habilidad = 10 + nivel;
        int velocidad = 10 + nivel;
        
        //crear un monstruo
        Monstruo m = new Monstruo("Monstruo nivel" + nivel, vida, fuerza, defensa, habilidad, velocidad);
        
        // lista
        list.add(m);
        
        System.out.println("Generado: " + m.getNombre());
        return m;
    }
   // eliminar monstruo
    public void eliminarMonstruo(){
        list.remove();
    }
        
}
