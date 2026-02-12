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
        
        fuerza[0] = new fuerza("Paladín", 8, 15, 7, 10, 3);
        defensa[1] = new defensa("Mago", 7, 8, 17, 8, 6);
        habilidad[2] = new habilidad("Pícaro", 8, 7, 10, 15, 9);
        velocidad[3] = new velocidad("Guerrero", 15, 10, 7, 8, 5);
        
        System.out.println("Valientes creados correctamente.");
    }
}
