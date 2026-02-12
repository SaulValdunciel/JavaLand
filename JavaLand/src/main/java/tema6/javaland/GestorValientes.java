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
    private Valiente[] valiente = new Valiente[4];

    public GestorValientes() {
    }

    @Override
    public void crear() {
        crearValientes();
    }

    // Crear los 4 valientes iniciales
    public void crearValientes() {
        String[] vida = null;
        vida[0] = "Guerrero (15,10,7,8)";
        
        String[] defensa = null;
        defensa[1] = "Paladín (8,15,7,10)";
        
        String[] habilidad = null;
        habilidad[2] = "Mago (7,8,17,8)";
        
        String[] velocidad = null;
        velocidad[3] = "Pícaro (8,7,10,15)";

        System.out.println("Valientes creados correctamente.");
    }
}
