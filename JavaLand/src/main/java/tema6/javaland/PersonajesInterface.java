/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author cuent
 */
public interface PersonajesInterface {
    
    //Métodos:
    
    public <T> void atacar(T Personaje);
    
    public int recibirDaño(int cantidad);
    
    public boolean ValienteUsarHabilidadEspecial();
    
    public int ValienteSubirNivel();
}
