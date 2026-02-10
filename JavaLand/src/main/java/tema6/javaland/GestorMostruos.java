/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;
import java.util.ArrayList;
/**
 *
 * @author cuent
 */
// Clase encargada de gestionar la creación y eliminación de monstruos.

public class GestorMostruos implements GestoresInterface {

    private ArrayList<Monstruo> lista = new ArrayList<>();

    public GestorMostruos() {
    }

    /**
     * Este método implementamos la interfaz.
     *  @Override.
     */
    @Override
    public void crear() {
        System.out.println("Use generarMonstruos(int nivel) para crear monstruos.");
    }

    // Genera un monstruo con estadísticas acordes al nivel indicado.
    
    public Monstruo generarMonstruos(int nivel) {

        int vida = 40 + nivel * 10;
        int fuerza = 5 + nivel;
        int defensa = 5 + nivel;
        int habilidad = 5 + nivel;
        int velocidad = 5 + nivel;

        Monstruo m = new Monstruo(
                "Monstruo Nv." + nivel,
                vida, fuerza, defensa, habilidad, velocidad, nivel
        );

        lista.add(m);
        return m;
    }

    //  Elimina monstruo de la lista cuando ha sido derrotado.
   
    public void eliminarMonstruo(Monstruo m) {
        lista.remove(m);
    }
}
