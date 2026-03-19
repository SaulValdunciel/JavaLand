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
    
 
    public void iniciarCombate(Valiente valiente, Monstruo monstruo);
 
    public <T> void turno( T atacante, T defensor);
   
    public void combateTerminado(Valiente valiente, Monstruo monstruo);    
    
}
