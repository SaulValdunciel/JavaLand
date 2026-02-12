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
public class Monstruo implements PersonajesInterface{
    
    protected int vida; // entre 0 y 100
    protected int fuerza; // entre 1 y 20
    protected int defensa; // entre 1 y 20
    protected int habilidad; // entre 1 y 20
    protected int velocidad; // entre 1 y 20
    protected int nivel;// define las estadísticas según GestorMosntruos

        @Override
    public <T> int atacar(T personaje) {


        Valiente valiente = (Valiente) personaje;
        Random random = new Random();
        int Variable_aleatoria = random.nextInt(101);
        int daño = 0;
        
        
        
        if (Variable_aleatoria < (4 * (habilidad -( valiente.getDefensa() + valiente.getEscudo().getDefensa())))) {
            
            
            
            
        }
        
        return daño;
    }

    @Override
    public int recibirDaño(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ValienteSubirNivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
