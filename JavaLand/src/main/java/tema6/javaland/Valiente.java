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
    private String valiente;
    private int vida;
    private int fuerza;
    private int defensa;
    private int habilidad;
    private int velocidad;
    private int nivel = 1;
    private Arma arma = null;
    private Escudo escudo = null;
    private int cooldownTurnos = 0;
    private static final int cooldown_max = 2;
    private int daño = 0;
  
    
    //Constructores
    public Valiente() {

    }

    public Valiente(String valiente, int vida, int fuerza, int defensa, int habilidad, int velocidad) {
        this.valiente = valiente;
        this.vida = vida;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.velocidad = velocidad;
    }

    //Metodos:
    @Override
    public <T> int atacar(T Personaje) {
        return daño;
    }

    //Metodo recibir daño sobrescrito de la interfaz
    @Override
    public int recibirDaño(int cantidad) {
        vida -= cantidad; //Resta la vida según la cantidad de daño recibida
        return vida; //Devuelve la vida 
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        if (cooldownTurnos > 0) {
            System.out.println("La habilidad está en cooldown (" + cooldownTurnos + ") turnos restantes.");
            return false;
        }
    }
        
        

    public Arma getArma() {
        return arma;
    }

    public Escudo getEscudo() {
        return escudo;
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

    public int getFuerza(){
        return defensa;
    }
    
    public int getHabilidad() {
        return habilidad;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    @Override
    public int ValienteSubirNivel() {
        nivel += 1; //Aumenta el nivel 
        vida += 10; //Aumenta la vida
        fuerza += 1; //Aumenta la fuerza
        defensa += 1; //Aumenta la defensa
        habilidad += 1; //Aumenta la habilidad
        velocidad += 1; //Aumenta la velocidad
        return nivel;
    }

    @Override
    public <T> void atacar(T Personaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
