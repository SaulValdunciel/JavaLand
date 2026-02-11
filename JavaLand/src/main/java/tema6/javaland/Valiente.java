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
    private int nivel = 1;
  
    
    //Constructores
    public Valiente() {

    }

    //Metodos:
    @Override
    public int atacar(int cantidad) {
        return cantidad;
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
            switch (valiente) {
                case "Guerrero":
                    //Habilidad especial guerrrero
                    break;
                case "Paladín":
                    //Habilidad especial paladin
                    break;
                case "Mago":
                    //Habilidad especial picaro
                    break;
                case "Picaro":
                    //Habilidad especial picaro
            }
        }
        cooldown = true;
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
        nivel += 1; //Aumenta el nivel 
        vida += 10; //Aumenta la vida
        fuerza += 1; //Aumenta la fuerza
        defensa += 1; //Aumenta la defensa
        habilidad += 1; //Aumenta la habilidad
        velocidad += 1; //Aumenta la velocidad
        return nivel;
    }

}
