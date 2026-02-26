/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

import java.util.Scanner;

/**
 *
 * @author DAM126
 */
public class Juego {
    Scanner teclado = new Scanner(System.in);
    private Mapa mapa;              // Mapa del juego
    private int valienteFila;       // Fila actual del valiente
    private int valienteColumna;    // Columna actual del valiente
    private boolean juegoActivo;    // Controla si el juego sigue activo

    // Constructor
    public Juego(int tamanoMapa) {
        mapa = new Mapa(tamanoMapa, false);  // Crear mapa sin revelar todo o revelando
        valienteFila = 0;                    // Posicion inicial del valiente (fila 0)
        valienteColumna = 0;                 // Posicion inicial del valiente (columna 0)
        juegoActivo = true;                  // El juego esta activo

        mapa.mapas();                         // Cargar un mapa aleatorio con rocas
        mapa.generarYMostrarMapa(valienteFila, valienteColumna); // Mostrar mapa inicial
    }

    // Metodo principal para iniciar el juego
    public void iniciarJuego() {


        System.out.println("Bienvenido a La Tierra de los Codigos Olvidados!");
        creacionOEleccionValiente(); // Crear o elegir valiente

        while (juegoActivo) {
            mostrarMenuPrincipal(); // Mostrar opciones del menu
            System.out.print("Elige una opcion: ");
            //Captura la linea completa que el usuario escribe y la guarda y se reinicia cada vez no hay qu cerrar ni limpiar
            String opcion = new Scanner(System.in).nextLine();//Captura la linea completa que el usuario escribe y la guarda y se reinicia cada vez no hay qu cerrar ni limpiar

            switch (opcion) {
                case "1":
                    mostrarValiente();   // Mostrar informacion del valiente
                    break;
                case "2":
                    equiparObjeto();     // Equipar objeto desde inventario
                    break;
                case "3":
                    mapa.mostrarMapa(valienteFila, valienteColumna); // Mostrar mapa
                    break;
                case "4":
                    explorarMapa(); // Moverse y explorar mapa
                    break;
                case "5":
                    System.out.println("Saliendo del juego...");
                    juegoActivo = false; // Terminar juego
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // Metodo para crear o elegir valiente
    public void creacionOEleccionValiente() {
        //Aqui GestorValientes
        System.out.println("Creando o eligiendo valiente...");
        mapa.revelarAdyacentes(valienteFila, valienteColumna); // Revelar casilla inicial y adyacentes
        mapa.mostrarMapa(valienteFila, valienteColumna);       // Mostrar mapa inicial
    }

    // Mostrar menu principal
    public void mostrarMenuPrincipal() {
        System.out.println("     Menu Principal");
        System.out.println("1. Mostrar valiente");
        System.out.println("2. Equipar objeto");
        System.out.println("3. Mostrar mapa");
        System.out.println("4. Moverse / Explorar mapa");
        System.out.println("5. Salir del juego");
    }

    // Mostrar informacion del valiente
    public void mostrarValiente() {
        // Aqui se mostrarian atributos, inventario, etc.

        System.out.println("Mostrando informacion del valiente...");
    }

    // Equipar objeto 
    public void equiparObjeto() {
        // Aqui se mostrarian objetos, inventario.
        System.out.println("Equipando objeto...");
    }

   // Metodo para mover y explorar el mapa
public void explorarMapa() {
    
    boolean explorando = true; // Controla el bucle de movimiento

    while (explorando) {
        try {
        // Mostrar mapa con la posicion actual del valiente
        mapa.mostrarMapa(valienteFila, valienteColumna);

        System.out.println("Moverse: w=arriba, s=abajo, a=izquierda, d=derecha");
        System.out.println("Presiona 'x' para salir de movimiento");
        System.out.print("Direccion: ");
        String direcion = new Scanner(System.in).nextLine().toLowerCase();

        // Permitir salir del bucle de movimiento
        if (direcion.equalsIgnoreCase("x")) {
            explorando = false;
            System.out.println("Saliendo del modo de movimiento...");
        }

        // Calcular nueva posicion
        int nuevaFila = valienteFila;
        int nuevaColumna = valienteColumna;

        switch (direcion) {
            case "w": 
                nuevaFila--;
                break;
            case "s":
                nuevaFila++; 
                break;
            case "a": 
                nuevaColumna--; 
                break;
            case "d": 
                nuevaColumna++; 
                break;
            default:
                System.out.println("Direccion no valida.");
                nuevaFila = valienteFila; // No moverse
                nuevaColumna = valienteColumna;
        }

        // Solo intentar mover si hay cambio de posicion
        if (nuevaFila != valienteFila || nuevaColumna != valienteColumna) {

            // Comprobar limites del mapa
            if (mapa.posicionValida(nuevaFila, nuevaColumna)) {

                // Comprobar si hay roca
                String casillaDestino = mapa.leerCasilla(nuevaFila, nuevaColumna);
                if (!casillaDestino.equals("R")) {

                    // Movimiento permitido
                    valienteFila = nuevaFila;
                    valienteColumna = nuevaColumna;

                    // Revelar casilla actual y adyacentes
                    mapa.revelarAdyacentes(valienteFila, valienteColumna);

                    // Revisar contenido de la casilla
                    if (casillaDestino.equals("M")) {
                        System.out.println("¡Un monstruo aparece! Iniciando combate...");
                         // Combate.iniciarCombate
                        mapa.limpiarCasilla(valienteFila, valienteColumna);
                        explorando = false; // Salir del bucle de movimiento
                    } else if (casillaDestino.equals("O")) {
                        System.out.println("Has encontrado un objeto.");
                        mapa.limpiarCasilla(valienteFila, valienteColumna);
                         // Inventario.agregarObjeto
                        explorando = false; // Salir del bucle de movimiento
                    } else if (casillaDestino.equals(".")) {
                        System.out.println("La casilla esta vacia.");
                    }

                } else {
                    System.out.println("Hay una roca! No puedes moverte ahi.");
                }

            } else {
                System.out.println("No puedes moverte fuera del mapa.");
            }

        } else {
            // No se mueve
            if (!direcion.equals("w") && !direcion.equals("s") && !direcion.equals("a") && !direcion.equals("d")) {
                // Direccion invalida ya impresa
            } else {
                System.out.println("No puedes moverte en esa direccion.");
            }
        }
    }catch(NumberFormatException e){
        System.out.println("Error: introduce un numero");
    }catch(IllegalArgumentException e){
        System.out.println("Opcion fuera del menu");
    }catch(NullPointerException e){
        System.out.println("Acceder a array sin crearlo");
    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Error Indice fuera del array");
    }catch(Exception e){
        System.out.println("Error desconocido");
    } 
  }    
}



    // Mostrar estado del juego
    public void mostrarEstadoJuego() {
        // Aqui se mostrarian monstruos derrotados, objetos recojido, etc.
        System.out.println("Mostrando estado del juego...");
    }
}
