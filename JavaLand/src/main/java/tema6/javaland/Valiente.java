/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author cuent
 */
public class Valiente extends GestorValientes implements PersonajesInterface {

    //Atributos
    private int cantidad;
    private boolean cooldown = false;
    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;

    //Constructores
    public Valiente() {

    }

    //Metodos:
    @Override
    public <T> void atacar(T Personaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Metodo recibir daño sobrescrito de la interfaz
    @Override
    public int recibirDaño(int cantidad) {
        vida -= cantidad; //Resta la vida según la cantidad de daño recibida
        return vida; //Devuelve la vida 
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        if (cooldown == true) {
            System.out.println("La habilidad está en cooldown no puedes usarla.");
            cooldown = false;
        } else {
            switch(nombre) 
                case "guerrero":
                    
                    break;
                case "paladin":
                   
                    break;
                case "mago":
                   
                    break;
                case "picaro":
                   
            }
            cooldown=true;
        }
    
    public boolean getCooldown() {
        return cooldown;
    }

    public int getVida() {
        return vida;
    }
    
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public int ValienteSubirNivel() {
        vida = vida + 10; //Aumenta la vida
        fuerza = fuerza + 1; //Aumenta la fuerza
        defensa = defensa + 1; //Aumenta la defensa
        habilidad = habilidad + 1; //Aumenta la habilidad
        velocidad = velocidad + 1; //Aumenta la velocidad
        return vida + fuerza + defensa + habilidad + velocidad;
    }

}
