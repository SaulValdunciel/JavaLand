/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Random;

/**
 *
 * @author cuent
 */
public class Monstruo {
    
    protected int vida; // entre 0 y 100
    protected int fuerza; // entre 1 y 20
    protected int defensa; // entre 1 y 20
    protected int habilidad; // entre 1 y 20
    protected int velocidad; // entre 1 y 20
    protected int nivel;// define las estadísticas según GestorMosntruos

    public int atacar(Valiente valiente) {

        Random random = new Random();
        int Variable_aleatoria = random.nextInt(101);
        int daño = 0;
        
        if (Variable_aleatoria < (4 * (habilidad -(valiente.getDefensa() + valiente.getEscudo().getDefensa())))) {
            
            
            
            
        }
        
        return daño;
    }

    public int recibirDaño() {

        int daño = 0;

        return daño;

    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    
}
