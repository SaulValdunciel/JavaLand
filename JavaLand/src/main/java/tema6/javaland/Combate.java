/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Random;
import java.util.Scanner;

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
        
        //terminar combate
        combateTerminado(valiente, monstruo);

    }

    @Override
    public <T> void turno(T atacante, T defensor) {

<<<<<<< Updated upstream
=======
        //variables
        int opcion=0;
        boolean salir=false;
        
>>>>>>> Stashed changes
        //si el atacante es un objeto de Valiente
        if (atacante instanceof Valiente) {

            Valiente valiente = (Valiente) atacante;
            Monstruo monstruo = (Monstruo) defensor;
<<<<<<< Updated upstream
            //atacar al monstruo
            int daño = valiente.atacar(defensor);
=======
        do {    
            System.out.println("\n-MENU DE BATALLA-");
            System.out.println("1. Ataque básico");
            System.out.println("2. Habilidad especial");
            System.out.println("3. Abrir mochila");
            
            switch(opcion){
            
                case 1 -> {//ataque normal
                
                    int daño = valiente.atacar(defensor);
>>>>>>> Stashed changes

            if (daño > 0) {

                System.out.println("El " + monstruo.getNombre() + " ha recibido "
                        + daño + " puntos de daño");

                monstruo.recibirDaño(daño);

            } else {

                System.out.println("El ataque falló");
            }
<<<<<<< Updated upstream
=======
                    
                    
                }
                
                case 2 -> {//usar habilidad especial, se lanza en el siguiente turno al atacar
                
                    if (!valiente.ValienteUsarHabilidadEspecial()) {
                        
                        System.out.println("Habilidad lanzada");
                    } else {
                    
                        System.out.println("Habilidad en cooldown");
                    }   
                    
                }
                
                case 3 -> {//curarse
                
                    
                    //mirar si hay objeto curativo
                    if (valiente.getInventario().TienePlantaCurativa()) {
                        
                        System.out.println("-MOCHILA-");
                        
                        System.out.println(valiente.getInventario());
                        
                        System.out.println("¿usar objeto? (s/n)");
                        
                        String aux = new Scanner(System.in).nextLine().trim();
                        
                        if (aux.equalsIgnoreCase(aux)) {
                            valiente.getInventario().UsarObjeto("planta");
                        } else {
                        
                            
                        }
                        
                    }

                }
                
                case 4 -> {
                
                    salir = true;
                
                }
                
                default -> {
                
                    System.out.println("Default");
                }
            }
        } while(!salir);
           
            
            
>>>>>>> Stashed changes

        } else {// si el atacante es un objeto de Monstruo

            Monstruo monstruo = (Monstruo) atacante;
            Valiente valiente = (Valiente) defensor;

            int daño = monstruo.atacar(defensor);
            //atacar al valiente
            if (daño > 0) {

                System.out.println("El " + valiente.getClase()
                        + " ha recibido " + daño + " puntos de daño");
                valiente.recibirDaño(daño);

                System.out.println("Al " + valiente.getClase() + " le quedan "
                        + valiente.getVida() + " puntos de vida");
            } else {

                System.out.println("El ataque falló");
            }

        }

    }

    @Override
    public void combateTerminado(Valiente valiente, Monstruo monstruo) {
        
        if(valiente.getVida() > 0) {//subir de nivel y mostrar valiente
        
            System.out.println("¡Ha ganado el combate! Subes de nivel");
            
            //subir estadisticas
            valiente.ValienteSubirNivel();
            
            //mostrar estadisicas
            System.out.println(valiente.toString());
            
        } else {//perder combate
        
            System.out.println("Has muerto");
        }
        
    }

}
