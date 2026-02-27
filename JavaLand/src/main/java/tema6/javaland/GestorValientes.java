/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Scanner;

/**
 *
 * @author cuent
 */
// Esta clase controla los valientes del juego
public class GestorValientes implements GestoresInterface {

    // Array simple para guardar nombres de valientes
    private Valiente[] valientes;

    public GestorValientes() {

        crear();
    }

    //crear valientes por defecto
    @Override
    public void crear() {

        valientes = new Valiente[4];
        valientes[0] = new Valiente("guerrero", 15, 10, 7, 8, 8);
        valientes[1] = new Valiente("paladin", 8, 15, 7, 10, 7);
        valientes[2] = new Valiente("mago", 7, 8, 17, 8, 8);
        valientes[3] = new Valiente("picaro", 8, 7, 10, 15, 10);

    }

    public int crear2() {

        //variables
        String clase = "";
        int puntos = 40;
        int aux = 0;
        int indice = 0;

        while (!clase.equalsIgnoreCase("guerrero") && !clase.equalsIgnoreCase("paladin")
                && !clase.equalsIgnoreCase("mago") && !clase.equalsIgnoreCase("picaro")) {

            System.out.println("Elegir clase: Guerrero, Paladín, Mago, Picaro");
            clase = new Scanner(System.in).nextLine().trim().toLowerCase();

        }
        
        switch(clase){//aisgnar un indice segun la clase
        
            case "guerrero"-> {
            
                indice = 0;
            }
            
            case "paladin" -> {
            
                 indice = 1;
            }
            
            case "mago" -> {
            
                indice = 2;
            }
            
            case "picaro" -> {
            
                indice = 3;
            }
            
            default ->{
            
                System.out.println("default");
            }
            
        }

      

        for (int i = 0; i < valientes.length; i++) {

            if (valientes[i].getClase().equalsIgnoreCase(clase)) {

                //gastar puntos en las estadisticas
                System.out.println(puntos + " puntos disponibles");

                do {

                    //vida
                    System.out.println("Vida: (entre 0 - 100) ");
                    aux = new Scanner(System.in).nextInt();
                    valientes[i].setVida(aux);

                    System.out.println(puntos + " puntos disponibles");

                    //fuerza
                    System.out.println("Fuerza: ");
                    aux = new Scanner(System.in).nextInt();
                    valientes[i].setFuerza(aux);

                    puntos -= aux;

                    System.out.println(puntos + " puntos disponibles");

                    //defensa
                    System.out.println("Defensa: ");
                    aux = new Scanner(System.in).nextInt();
                    valientes[i].setDefensa(aux);

                    puntos -= aux;

                    System.out.println(puntos + " puntos disponibles");

                    //habilidad
                    System.out.println("Habilidad: ");
                    aux = new Scanner(System.in).nextInt();
                    valientes[i].setHabilidad(aux);

                    puntos -= aux;

                    System.out.println(puntos + " puntos disponibles");

                    //velocidad
                    System.out.println("Velocidad: ");
                    aux = new Scanner(System.in).nextInt();
                    valientes[i].setVelocidad(aux);

                } while (puntos > 0);

            }
        }

        return indice;
    }

    //devuelve el valiente que se encuentra en el indice
    public Valiente getValiente(int indice) {
        return valientes[indice];
    }

    public void mostrarLista() {

        for (int i = 0; i < valientes.length; i++) {

            System.out.println(valientes[i].toString());
        }
    }

}
