/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tema6.javaland;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author cuent
 */
public class JavaLand {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        int tamanoMapa = 15;
        
        
        // Crear juego
        Juego juego = new Juego(tamanoMapa);
        

        // Iniciar juego
        juego.iniciarJuego();
    }
}
