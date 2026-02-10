/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author cuent
 */
public class Valientes extends GestorValientes implements PersonajesInterface {

    //Atributos
    private int cantidad;
    //Constructores
    public Valientes(){
        
    }
    //Metodos:
    @Override
    public <T> void atacar(T Personaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Metodo recibir daño sobrescrito de la interfaz
    @Override
    public int recibirDaño(int cantidad) {
        vida=vida-cantidad; //Resta la vida según la cantidad de daño recibida
        return vida; //Devuelve la vida 
    }

    @Override
    public boolean ValienteUsarHabilidadEspecial() {
        
    }

    //Método para subir de nivel al valiente
    @Override
    public int ValienteSubirNivel() {
        vida=vida+10; //Aumenta la vida
        fuerza=fuerza+1; //Aumenta la fuerza
        defensa=defensa+1; //Aumenta la defensa
        habilidad=habilidad+1; //Aumenta la habilidad
        velocidad=velocidad+1; //Aumenta la velocidad
    }
}
