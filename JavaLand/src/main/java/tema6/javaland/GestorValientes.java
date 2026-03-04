/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author cuent
 */
// Esta clase controla los valientes del juego
public class GestorValientes implements GestoresInterface {

    private Valiente[] valientes;

   /**
    * Constructor que llama al metodo crear() que genera los valientes por defecto
    * @author Maya
    */
    public GestorValientes() {

        try {
            crear();
        } catch (Exception e) {
            System.out.println("Error al crear los valientes.");
        }
    }

    /**
     * crear valientes por defecto
     * @author Maya, Saúl
     * 
     */
    @Override
    public void crear() {

        try {

            valientes = new Valiente[4];
            valientes[0] = new Valiente("guerrero", 15, 10, 7, 8, 8);
            valientes[1] = new Valiente("paladin", 8, 15, 7, 10, 7);
            valientes[2] = new Valiente("mago", 7, 8, 17, 8, 8);
            valientes[3] = new Valiente("picaro", 8, 7, 10, 15, 10);

        } catch (NullPointerException e) {
            System.out.println("Error al inicializar el array de valientes.");
        } catch (Exception e) {
            System.out.println("Error desconocido al crear los valientes.");
        }

    }
    
    /**
     * Crear un valiente según su clase y sustituirlo con los nuevos datos
     * en la posición del array que corresponda
     * @return 
     * @author Maya
     */

    public int crear2() {

        //variables
        String clase = "";
        int puntos = 40;// puntos para repartir
        int aux = 0; //valor temporal
        int indice = 0;// indice del valiente elegido
        boolean salir = false;

        Scanner sc = new Scanner(System.in);
        try {
            //elegir clase vida
            while (!clase.equalsIgnoreCase("guerrero") && !clase.equalsIgnoreCase("paladin")
                    && !clase.equalsIgnoreCase("mago") && !clase.equalsIgnoreCase("picaro")) {

                System.out.println("Elegir clase: Guerrero, Paladín, Mago, Picaro");
                clase = new Scanner(System.in).nextLine().trim().toLowerCase();

            }

            switch (clase) {//aisgnar un indice segun la clase

                case "guerrero" -> {

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

                default -> {

                    System.out.println("default");
                }

            }

            // Buscar el valiente correspondiente y modificar sus estadísticas
            for (int i = 0; i < valientes.length; i++) {

                if (valientes[i].getClase().equalsIgnoreCase(clase)) {


                    do {

                        //vida
                        valientes[i].setVida(100);

                        System.out.println(puntos + " puntos disponibles");
                        try {
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

                            salir = true;
                        } catch (InputMismatchException e) {

                            System.out.println("Error: debes introducir un número.");
                            sc.nextLine(); // limpiar buffer
                        }
                    } while (puntos > 0 && !salir);

                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: índice fuera del array.");

        } catch (NullPointerException e) {

            System.out.println("Error: el array de valientes no está inicializado.");

        } catch (Exception e) {

            System.out.println("Error desconocido al crear el valiente.");
        }


        switch (clase) {//aisgnar un indice segun la clase

            case "guerrero" -> {

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

            default -> {

                System.out.println("default");
            }

        }

        // Buscar el valiente correspondiente y modificar sus estadísticas
        for (int i = 0; i < valientes.length; i++) {

            if (valientes[i].getClase().equalsIgnoreCase(clase)) {

                //gastar puntos en las estadisticas
                System.out.println(puntos + " puntos disponibles");

                do {

                    //vida
                    valientes[i].setVida(100);
                   valientes[i].setVidaMaxima(100);

                    

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

                    salir = true;

                } while (puntos > 0 || !salir);

            }
        }


        return indice;
    }
    //devuelve el valiente que se encuentra en el indice

    /**
     * devueleve un valiente del array según el índice que recibe por parametro
     * @param indice
     * @return
     * @author Maya, Saúl
     * 
     */
    public Valiente getValiente(int indice) {
        try {
            return valientes[indice];
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: índice de valiente inválido.");
            return null;

        } catch (NullPointerException e) {

            System.out.println("Error: el array de valientes no está creado.");
            return null;
        }
    }

    /**
     * 
     * muestra la lista de valientes
     * @author Maya, Saúl
     * 
     */
    public void mostrarLista() {

        try {

            for (int i = 0; i < valientes.length; i++) {

                System.out.println(valientes[i].toString());
            }

        } catch (NullPointerException e) {

            System.out.println("Error: no hay valientes creados.");

        } catch (Exception e) {

            System.out.println("Error al mostrar la lista de valientes.");
        }
    }

}
