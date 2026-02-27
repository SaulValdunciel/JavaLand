/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tema6.javaland;

/**
 *
 * @author cuent
 */
public class JavaLand {

    public static void main(String[] args) {
        int tamanoMapa = 15;
        
        
        // Crear juego
        Juego juego = new Juego(tamanoMapa);
        

        // Iniciar juego
        juego.iniciarJuego();
    }
}
