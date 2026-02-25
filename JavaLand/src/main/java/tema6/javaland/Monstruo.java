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
public class Monstruo implements PersonajesInterface {

    protected String nombre;//nombre del monstruo
    protected int vida; // entre 0 y 100
    protected int fuerza; // entre 1 y 20
    protected int defensa; // entre 1 y 20
    protected int habilidad; // entre 1 y 20
    protected int velocidad; // entre 1 y 20
    protected int nivel;// define las estadísticas según GestorMosntruos
    protected static int contador = 0; // contador de monstruos totales

    public Monstruo(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
        this.nivel = nivel;
        contador++;
    }

    @Override
    public <T> int atacar(T personaje) {

        Valiente valiente = (Valiente) personaje;
        Random random = new Random();
        int Variable_aleatoria = random.nextInt(101);
        int daño;

        if (Variable_aleatoria < (4 * (habilidad - (valiente.getDefensa() + valiente.getEscudo().getDefensa())))) {

            //restar vida al valiente según la fuerza del monstruo
            daño = valiente.getVida() - fuerza;

        } else {
        
            daño = 0;
        }

        return daño;
    }

    @Override
    public int recibirDaño(int cantidad) {
        
        vida -= cantidad;
        
        return vida;
    }
    
    public void monstruosTotales(int num){
    
         contador = num;
        
    }


    //getters y setters
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    //no usar
    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int ValienteSubirNivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
