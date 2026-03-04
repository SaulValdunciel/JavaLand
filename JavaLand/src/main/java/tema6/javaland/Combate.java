/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author M
 */
public class Combate implements CombateInterface {

    public Combate() {
    }

    /**
     * comienza el combate con los dos objetos recibidos por parámetro y decide
     * el orden de ataque según la iniciativa que se calcula en cada iteración
     *
     * @param valiente
     * @param monstruo
     * @author Maya, Saúl
     */
    @Override
    public void iniciarCombate(Valiente valiente, Monstruo monstruo) {
        
        

        int contTurnos = 1;
        try {
            if (valiente == null || monstruo == null) {
                System.out.println("Error: valiente o monstruo es null. No se puede iniciar combate.");
                return;
            }
            //mostrar monstruo al que se va a enfrentar
            System.out.println("Aparece un " + monstruo.getNombre() + " de nivel "
                    + monstruo.getNivel());
            do {//bucle hasta que la vida de valiente o monstruo llegue a 0 o menos

                //determinar orden
                Random randomV = new Random();//aleatorio para la iniciativa del valiente
                double Iniciativa_Valiente = valiente.getVelocidad() * (randomV.nextDouble(1) + 0.75);

                Random randomM = new Random();//aleatorio para la iniciativa del monstruo
                double Iniciativa_Monstruo = monstruo.getVelocidad() * (randomM.nextDouble(1) + 0.75);

                //orden de los turnos según la iniciativa
                if (Iniciativa_Valiente > Iniciativa_Monstruo) {

                    System.out.println("");
                    System.out.println("\tTURNO " + contTurnos);
                    turno(valiente, monstruo);
                    turno(monstruo, valiente);
                    contTurnos++;

                } else {

                    System.out.println("");
                    System.out.println("ºtTURNO " + contTurnos);
                    turno(monstruo, valiente);
                    turno(valiente, monstruo);
                    contTurnos++;
                }

            } while (valiente.getVida() > 0 && monstruo.getVida() > 0);

            //terminar combate
            combateTerminado(valiente, monstruo);
        } catch (NullPointerException e) {
            System.out.println("Error: se ha intentado usar un objeto null durante el combate.");
        } catch (Exception e) {
            System.out.println("Error desconocido al iniciar el combate.");
        }
    }

    /**
     * gestiona las acciones de los personajes involucrados en el combate Los
     * monstruos atacan automáticamente y los valientes pueden elegir entre
     * varias opciones.
     *
     * @param <T>
     * @param atacante
     * @param defensor
     * @author Maya, Saúl
     */

    @Override
    public <T> void turno(T atacante, T defensor) {

        //variables
        int opcion = 0;
        boolean finAccion = false;

        //si el atacante es un objeto de Valiente
        if (atacante instanceof Valiente) {

            Valiente valiente = (Valiente) atacante;
            Monstruo monstruo = (Monstruo) defensor;

            do {

                try {

                    do {

                        System.out.println("");
                        System.out.println("  +================================+");
                        System.out.println("  |       MENU DE BATALLA          |");
                        System.out.println("  +================================+");
                        System.out.println("  |  1.  Ataque básico             |");
                        System.out.println("  |  2.  Habilidad especial        |");
                        System.out.println("  |  3.  Abrir mochila             |");
                        System.out.println("  +================================+");
                        System.out.println("");

                        opcion = new Scanner(System.in).nextInt();

                        switch (opcion) {

                            case 1 -> {//ataque normal

                                int daño = valiente.atacar(defensor);

                                if (daño > 0) {

                                    System.out.println(monstruo.getNombre() + " ha recibido "
                                            + daño + " puntos de daño");
                                    System.out.println("");

                                    monstruo.recibirDaño(daño);

                                    System.out.println(monstruo.toString());
                                    System.out.println("");

                                } else {

                                    System.out.println("Tu ataque falló");
                                    System.out.println("");

                                }
                                valiente.tickCooldown();
                                finAccion = true;

                            }

                            case 2 -> {
                                boolean usada = valiente.ValienteUsarHabilidadEspecial();

                                // Cooldown bien: true = usada, false = en cooldown
                                if (usada) {
                                    System.out.println("Habilidad lanzada. Cooldown: " + valiente.getCooldownHabilidad() + " turnos.");
                                    // Si la habilidad consume turno:
                                    finAccion = true;
                                } else {
                                    System.out.println("No puedes usar la habilidad. Cooldown: "
                                            + valiente.getCooldownHabilidad() + " turnos.");
                                    System.out.println("Elige otra opción.");
                                    // no consume el turno
                                }
                            }

                            case 3 -> {//curarse

                                if (valiente.getVida() < valiente.getVidaMaxima()) {//curar solo si le falta vida

                                    //llamar metodo de curacion
                                    valiente.getInventario().UsarObjeto("Planta Curativa", valiente);
                                    valiente.tickCooldown();
                                    finAccion = true;

                                } else {

                                    System.out.println("No puedes curarte cuando tienes la vida la máximo");
                                    System.out.println("");

                                }

                            }

                            default -> {

                                System.out.println("Default");
                            }
                        }
                    } while (opcion < 1 || opcion > 3);
                } catch (NumberFormatException e) {

                    System.out.println("debes introducir un numero");
                } catch (InputMismatchException e) {
                    System.out.println("formato incorrecto");
                } catch (Exception e) {

                    System.out.println("Excepcion desconocida");
                }
            } while (!finAccion);

            //atacar al monstruo
        } else {// si el atacante es un objeto de Monstruo

            Monstruo monstruo = (Monstruo) atacante;
            Valiente valiente = (Valiente) defensor;

            int daño = monstruo.atacar(defensor);
            //atacar al valiente
            if (daño > 0) {

                System.out.println("El " + valiente.getClase()
                        + " ha recibido " + daño + " puntos de daño");
                valiente.recibirDaño(daño);
                System.out.println("");

                System.out.println("Al " + valiente.getClase() + " le quedan "
                        + valiente.getVida() + " puntos de vida");
                System.out.println("");
            } else {

                System.out.println("El ataque del monstruo falló");
                System.out.println("");
            }

        }

    }

    /**
     * Sube de nivel al valiente cada vez que gana una pelea o termina sale del
     * bucle de combate para terminar el juego.
     *
     * @param valiente
     * @param monstruo
     * @author Maya, Saúl
     */
    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {

        try {
            if (valiente == null || monstruo == null) {
                System.out.println("Error: combate terminado con valiente/monstruo null.");
                return;
            }

            if (valiente.getVida() > 0) {//subir de nivel y mostrar valiente

                System.out.println("¡Has ganado el combate! Subes de nivel");

                //subir estadisticas
                valiente.ValienteSubirNivel();

                //mostrar estadisicas
                System.out.println(valiente.toString());

            } else {//perder combate

                System.out.println("Has muerto");
            }
        } catch (NullPointerException e) {
            System.out.println("Error: null al terminar el combate.");
        } catch (Exception e) {
            System.out.println("Error desconocido al terminar el combate.");
        }

    }

}
