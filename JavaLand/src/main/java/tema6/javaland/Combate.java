/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Random;

/**
 *
 * @author M
 */
public class Combate implements CombateInterface {

    @Override
    public void iniciarCombate(Valiente valiente, Monstruo monstruo) {

        do {//bucle hasta que la vida de valiente o monstruo llegue a 0 o menos

            Random randomV = new Random();//aleatorio para la iniciativa del valiente
            double Iniciativa_Valiente = valiente.getVelocidad() * (randomV.nextDouble(1) + 0.75);

            Random randomM = new Random();//aleatorio para la iniciativa del monstruo
            double Iniciativa_Monstruo = monstruo.getVelocidad() * (randomM.nextDouble(1) + 0.75);
            
            //determinar el orden de los turnos según la iniciativa
            if (Iniciativa_Valiente > Iniciativa_Monstruo){
            
                turno(valiente,monstruo);
                
                
            } else {
            
                turno(monstruo, valiente);
            }

        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);

    }

    @Override
    public <T> void turno(T atacante, T defensor) {
        
        //si el atacante es un objeto de Valiente
        if (atacante instanceof Valiente) {
            
            Valiente valiente = (Valiente) atacante;
            //atacar al monstruo
            valiente.atacar(defensor);
            
        } else {// si el atacante es un objeto de Monstruo
        
            Monstruo monstruo = (Monstruo) atacante;
            //atacar al valiente
            monstruo.atacar(defensor);
        }
        
    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
    }

}
