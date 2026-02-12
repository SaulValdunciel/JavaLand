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
            if (Iniciativa_Valiente > Iniciativa_Monstruo) {

                turno(valiente, monstruo);
                turno(monstruo,valiente);

            } else {

                turno(monstruo, valiente);
                turno(valiente,monstruo);
            }

        } while (valiente.getVida() > 0 && monstruo.getVida() > 0);

    }

    @Override
    public <T> void turno(T atacante, T defensor) {

        //si el atacante es un objeto de Valiente
        if (atacante instanceof Valiente) {

            Valiente valiente = (Valiente) atacante;
            Monstruo monstruo = (Monstruo) defensor;
            //atacar al monstruo
            int daño = valiente.atacar(defensor);

            if (daño > 0) {

                System.out.println("El " + monstruo.getNombre() + " ha recibido "
                        + daño + " puntos de daño");

                monstruo.recibirDaño(daño);

            } else {

                System.out.println("El ataque falló");
            }

        } else {// si el atacante es un objeto de Monstruo

            Monstruo monstruo = (Monstruo) atacante;
            Valiente valiente = (Valiente) defensor;

            int daño = monstruo.atacar(defensor);
            //atacar al valiente
            if (daño > 0) {

                System.out.println("El " + valiente.getValiente()
                        + " ha recibido " + daño + " puntos de daño");
                valiente.recibirDaño(daño);

                System.out.println("Al " + valiente.getValiente() + " le quedan "
                        + valiente.getVida() + " puntos de vida");
            } else {

                System.out.println("El ataque falló");
            }

        }

    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
    }

}
