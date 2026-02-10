/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM126
 */
public class Mapa {

    //Mapa de 10x10 representado con Strings
    //Cada posición es una casilla del mapa
    private String[][] Casilla = new String[10][10];

    /*
     * Constructor del mapa
     * Si revelarTodo es true
     */
    public Mapa(boolean revelarTodo) {

        // Inicializamos todas las casillas
        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 10; columna++) {

                if (revelarTodo) {
                    // Casilla revelada y vacía
                    Casilla[fila][columna] = ".";
                } else {
                    // Casilla no revelada
                    Casilla[fila][columna] = "?";
                }
            }
        }
    }

    //Comprueba si una posición esta dentro del mapa
    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

    /*
     * Revela solo la casilla actual
     * fila y columna son los índices de la matriz
     */
    public void revelarCasilla(int fila, int columna) {
        if (posicionValida(fila, columna) && Casilla[fila][columna].equals("?")) {
            Casilla[fila][columna] = ".";
        }
    }

    /*
     * Revela la casilla actual y las adyacentes
     * (arriba, abajo, izquierda, derecha)
     */
    public void revelarAdyacentes(int fila, int columna) {
        revelarCasilla(fila, columna);       // actual
        revelarCasilla(fila - 1, columna);   // arriba
        revelarCasilla(fila + 1, columna);   // abajo
        revelarCasilla(fila, columna - 1);   // izquierda
        revelarCasilla(fila, columna + 1);   // derecha
    }

    //Coloca un monstruo en el mapa
    public void ponerMonstruo(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            Casilla[fila][columna] = "M";
        }
    }

    //Coloca un objeto en el mapa
    public void ponerObjeto(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            Casilla[fila][columna] = "O";
        }
    }
    //Coloca un Rocas en el mapa
    public void ponerRocas(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            Casilla[fila][columna] = "R";
        }
    }
    public boolean puedeColocar(int fila, int columna, int tamaño, boolean comprobar) {
        if (comprobar) {
            if (columna + tamaño > Casilla.length) {
                return false;
            }

            for (int i = 0; i < tamaño; i++) {
                if (!Casilla[fila][columna + i].equals("")) {
                    return false;
                }
            }
        } else {
            if (fila + tamaño > Casilla.length) {
                return false;
            }

            for (int i = 0; i < tamaño; i++) {
                if (!Casilla[fila + i][columna].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
    public void introducirComponentes(int fila, int columna){
        
    }

    /*
     * Muestra el mapa por consola
     * V = Valiente
     * M = Monstruo
     * O = Objeto
     * . = Vacío revelado
     * ? = No revelado
     */
    public void mostrarMapa(int valienteFila, int valienteColumna) {
        System.out.println("    0  1  2  3  4  5  6  7  8  9");
        System.out.println("    -  -  -  -  -  -  -  -  -  - ");

        for (int fila = 0; fila < Casilla.length; fila++) {//Aqui crea el mapa segun la cantidad de filas del array
            System.out.print(fila + "| ");
            for (int columna = 0; columna < Casilla.length; columna++) {//Aqui crea el mapa segun la cantidad de columna del array

                //Coloca al jugador en la casilla correspondiente
                if (fila == valienteFila && columna == valienteColumna) {
                    System.out.print(" V ");
                } else {
                    System.out.print(" " + Casilla[fila][columna] + " ");
                }
            }
            System.out.println();
        }
    }
}
