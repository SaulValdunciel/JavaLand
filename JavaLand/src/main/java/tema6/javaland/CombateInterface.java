/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author cuent
 */
public interface CombateInterface {
    
    //inicia el combate por turnos. hacer bucle hasta que valiente.hp o monstruo.hp == 0
    public void iniciarCombate(Valiente valiente, Monstruo monstruo);
    
    //gestionar acciones de atacante y defensor, calcular daño según fórmula
    public <T> void turno( T atacante, T defensor);
    
    //finalizar el comabate y subir las estadisticas del heroe si gana, impirimir el ganador con sus datos actuales
    public <T> void combateTerminado(T valiente, T monstruo);
    
    
    
}
