/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;
/**
 *
 * @author cuent
 */
// Esta clase controla los valientes del juego
public class GestorValientes implements GestoresInterface {
    // Array simple para guardar nombres de valientes
    private String[] nombres = {"Guerrero", "Paladín", "Mago", "Pícaro"};
    
    // Crear los 4 valientes iniciales
    private int[] vida = {15, 8, 7, 8};
    private int[] fuerza = {10, 15, 8, 7};
    private int[] defensa = {7, 7, 17, 10};
    private int[] velocidad = {8, 10, 8, 15};
    
    
    public GestorValientes() {
    }

    @Override
    public void crear() {
        crearValientes();
    }
    
    private void crearValientes() {
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i] + " (" +
                vida[i] + "," +
                fuerza[i] + "," +
                defensa[i] + "," +
                velocidad[i] + ")");
        }
    }

}
