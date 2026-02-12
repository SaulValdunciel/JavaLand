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

    //Mapa variable sengun las dificultades representado con Strings
    //Cada posición es una casilla del mapa
    // Matriz del mapa
    private String[][] Casilla;

    // Tamaño del mapa (n x n)
    private int tamano;

    /*
     * Constructor del mapa
     * tamano = tamaño del mapa (ej: 10 para 10x10)
     * revelarTodo = si empieza todo visible o no
     */
    public Mapa(int tamano, boolean revelarTodo) {

        this.tamano = tamano;
        Casilla = new String[tamano][tamano];

        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                if (revelarTodo) {
                    Casilla[fila][columna] = ".";
                } else {
                    Casilla[fila][columna] = "?";
                }
            }
        }
    }

    //Comprueba si una posición esta dentro del mapa
    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < tamano && columna >= 0 && columna < tamano;
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


    public void introducirComponentes(int fila, int columna) {

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

        // Mostrar numeros superiores
        System.out.print("     ");
        for (int i = 0; i < tamano; i++) {

            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // Línea separadora
        System.out.print("     ");
        for (int i = 0; i < tamano; i++) {
            System.out.print(" - ");
        }
        System.out.println();

        // Mostrar filas
        for (int fila = 0; fila < tamano; fila++) {

            if (fila < 10) {//Esto si el numero es menor a 10 ya que son 1 digito
                System.out.print(" " + fila + " | ");
            } else {
                System.out.print(fila + " | ");//este numeros mayor de 10 ya que teinen 2 digitos
            }

            for (int columna = 0; columna < tamano; columna++) {

                if (fila == valienteFila && columna == valienteColumna) {
                    System.out.print(" V ");
                } else {
                    System.out.print(" " + Casilla[fila][columna] + " ");
                }
            }
            System.out.println();
        }
    }

    /*
     * Metodo interno para colocar elementos automaticamente
     * elemento: "R", "M", "O"
     * cantidad: numero de elementos
     * comprobarAdyacentes: true solo para rocas
     */
    private void colocarElementos(String elemento, int cantidad, boolean comprobarAdyacentes) {

        int colocados = 0;

        while (colocados < cantidad) {

            int fila = (int) (Math.random() * tamano);
            int columna = (int) (Math.random() * tamano);

            boolean puedeColocar = true;

            if (!Casilla[fila][columna].equals(".")) {
                puedeColocar = false;
            }
            else if (comprobarAdyacentes) {
                if (comprobarAlrededor(fila, columna)) {
                    puedeColocar = false;
                }
            }

            if (puedeColocar) {
                Casilla[fila][columna] = elemento;
                colocados++;
            }
        }
    }
    private boolean comprobarAlrededor(int fila, int columna){
        if(fila > 0){
            if(!Casilla[fila -1][columna].equals(".")){
                return true;
            }
        }
        if(fila < 9){
            if(!Casilla[fila +1][columna].equals(".")){
                return true;
            }
        }
        if(columna > 0){
            if(!Casilla[fila][columna -1].equals(".")){
                return true;
            }
        }
        if(columna < 9){
            if(!Casilla[fila][columna +1].equals(".")){
                return true;
            }
        }
        return false;
    }
     public void generarYMostrarMapa(int valienteFila, int valienteColumna) {

        // Inicializar como vacío
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                Casilla[fila][columna] = ".";
            }
        }

        // Cantidades proporcionales al tamaño
        int totalCasillas = tamano * tamano;// 25% del mapa son rocas
        int rocas = totalCasillas / 4;
        int monstruos = 5;
        int objetos = 5;

        colocarElementos("R", rocas, true);
        colocarElementos("M", monstruos, false);
        colocarElementos("O", objetos, false);

        mostrarMapa(valienteFila, valienteColumna);
    }
}
