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
    
    @Override
    public void crear() {
        crearValientes();
    }
    
    public GestorValientes() {
        valiente[0] = new Valiente("Guerrero", 15, 10, 7, 8, 8);   
        valiente[1] = new Valiente("Paladín", 8, 15, 7, 10, 7);
        valiente[2] = new Valiente("Mago", 7, 8, 17, 8, 8);
        valiente[3] = new Valiente("Pícaro", 8, 7, 10, 15, 10);
    
    System.out.println("Valientes creados correctamente.");
    }

    private void crearValientes() {
    }
       
}
