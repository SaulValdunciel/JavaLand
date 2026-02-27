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
    private String[][] Casilla;   // lo que ve el jugador
    private String[][] Contenido; // lo que realmente hay en cada casilla

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
        Contenido = new String[tamano][tamano];

        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                Casilla[fila][columna] = revelarTodo ? "." : "?";
                Contenido[fila][columna] = "."; // todo vacío inicialmente
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
        Casilla[fila][columna] = Contenido[fila][columna]; // <- copiar el contenido real
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
    


    /*
     * Muestra el mapa por consola
     * V = Valiente
     * M = Monstruo
     * O = Objeto
     * . = Vacío revelado
     * ? = No revelado
     */
    public void mostrarMapa(int valienteFila, int valienteColumna) {

        // Mostrar filas
        for (int fila = 0; fila < tamano; fila++) {



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

        // Solo colocar en casillas vacías en el contenido real
        if (!Contenido[fila][columna].equals(".")) {
            puedeColocar = false;
        } else if (comprobarAdyacentes && comprobarAlrededor(fila, columna)) {
            puedeColocar = false;
        }

        if (puedeColocar) {
            Contenido[fila][columna] = elemento; // se coloca en contenido, sigue oculto en Casilla
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
        if(fila < tamano -1){
            if(!Casilla[fila +1][columna].equals(".")){
                return true;
            }
        }
        if(columna > 0){
            if(!Casilla[fila][columna -1].equals(".")){
                return true;
            }
        }
        if(columna < tamano -1){
            if(!Casilla[fila][columna +1].equals(".")){
                return true;
            }
        }
        return false;
    }
     public void generarYMostrarMapa(int valienteFila, int valienteColumna) {
    // colocar monstruos y objetos aleatorios solo si la casilla esta oculta
    int monstruos = 5;
    int objetos = 5;

    colocarElementos("M", monstruos, false);
    colocarElementos("O", objetos, false);

    // revelar la posicion inicial y adyacentes
    revelarAdyacentes(valienteFila, valienteColumna);

    // mostrar mapa inicial
    mostrarMapa(valienteFila, valienteColumna);
}

    
    //Metodo de mapas creados a mano que ponen las rocas
    public void mapas(){
        String[][] mapa1 = new String[tamano][tamano];
        String[][] mapa2 = new String[tamano][tamano];
        String[][] mapa3 = new String[tamano][tamano];
    
    
         mapa1[0][2]= "R";
         mapa1[1][2]= "R";mapa1[1][3]= "R";mapa1[1][9]= "R";
         mapa1[1][11]= "R";mapa1[1][14]= "R";
         mapa1[2][6]= "R";mapa1[2][11]= "R";
         mapa1[3][1]= "R";mapa1[3][4]= "R";mapa1[3][6]= "R";
         mapa1[3][11]= "R";mapa1[3][14]= "R";
         mapa1[4][2]= "R";mapa1[4][8]= "R";
         mapa1[5][6]= "R";mapa1[5][10]= "R";mapa1[5][14]= "R";
         mapa1[6][3]= "R";mapa1[6][6]= "R";mapa1[6][13]= "R";
         mapa1[7][8]= "R";mapa1[7][9]= "R";mapa1[7][10]= "R";
         mapa1[8][1]= "R";mapa1[8][7]= "R";mapa1[8][8]= "R";
         mapa1[8][9]= "R";mapa1[8][10]= "R";mapa1[8][11]= "R";mapa1[8][13]= "R";
         mapa1[9][8]= "R";mapa1[9][9]= "R";mapa1[9][10]= "R";mapa1[9][13]= "R";
         mapa1[10][4]= "R";mapa1[10][6]= "R";mapa1[10][9]= "R";
         mapa1[11][2]= "R";mapa1[11][4]= "R";
         mapa1[12][6]= "R";mapa1[12][11]= "R";mapa1[12][13]= "R";
         mapa1[13][11]= "R";
         mapa1[14][4]= "R";mapa1[14][7]= "R";mapa1[14][14]= "C";
         
         
         mapa2[0][2]= "R";mapa2[0][3]= "R";mapa2[0][4]= "R";mapa2[0][5]= "R";
         mapa2[1][0]= "R";mapa2[1][2]= "R";mapa2[1][3]= "R";
         mapa2[1][8]= "R";mapa2[1][11]= "R";
         mapa2[2][0]= "R";mapa2[2][8]= "R";
         mapa2[3][0]= "R";mapa2[3][3]= "R";mapa2[3][4]= "R";
         mapa2[3][7]= "R";mapa2[3][8]= "R";mapa2[3][9]= "R";
         mapa2[3][11]= "R";mapa2[3][12]= "R";mapa2[3][13]= "R";
         mapa2[4][0]= "R";mapa2[4][3]= "R";mapa2[4][4]= "R";
         mapa2[4][8]= "R";mapa2[4][13]= "R";
         mapa2[5][0]= "R";mapa2[5][2]= "R";mapa2[5][3]= "R";
         mapa2[5][4]= "R";mapa2[5][11]= "R";mapa2[5][13]= "R";
         mapa2[6][0]= "R";mapa2[6][5]= "R";mapa2[6][13]= "R";
         mapa2[7][0]= "R";mapa2[7][8]= "R";mapa2[7][11]= "R";
         mapa2[8][0]= "R";mapa2[8][3]= "R";mapa2[8][7]= "R";
         mapa2[8][8]= "R";mapa2[8][9]= "R";mapa2[8][13]= "R";
         mapa2[9][0]= "R";mapa2[9][6]= "R";mapa2[9][7]= "R";mapa2[9][8]= "R";
         mapa2[9][9]= "R";mapa2[9][10]= "R";mapa2[9][13]= "R";
         mapa2[10][0]= "R";mapa2[10][1]= "R";mapa2[10][3]= "R";
         mapa2[10][7]= "R";mapa2[10][8]= "R";mapa2[10][9]= "R";
         mapa2[10][13]= "R";mapa2[10][14]= "R";
         mapa2[11][0]= "R";mapa2[11][5]= "R";mapa2[11][8]= "R";mapa2[11][11]= "R";
         mapa2[12][0]= "R";mapa2[12][4]= "R";mapa2[12][5]= "R";mapa2[12][6]= "R";
         mapa2[13][0]= "R";mapa2[13][8]= "R";mapa2[13][10]= "R";mapa2[13][13]= "R";
         mapa2[14][0]= "R";mapa2[14][1]= "R";mapa2[14][2]= "R";mapa2[14][5]= "R";
         mapa2[14][6]= "R";mapa2[14][9]= "R";mapa2[14][10]= "R";
         mapa2[14][11]= "R";mapa2[14][12]= "R";mapa2[14][13]= "R";mapa2[14][14]= "C";
         
         
         mapa3[0][5]= "R";mapa3[0][6]= "R";mapa3[0][7]= "R";mapa3[0][8]= "R";
         mapa3[0][9]= "R";mapa3[0][10]= "R";mapa3[0][11]= "R";
         mapa3[0][12]= "R";mapa3[0][13]= "R";mapa3[0][14]= "R";
         mapa3[1][3]= "R";mapa3[1][5]= "R";mapa3[1][14]= "R";
         mapa3[2][3]= "R";mapa3[2][9]= "R";mapa3[2][11]= "R";
         mapa3[2][13]= "R";mapa3[2][14]= "R";
         mapa3[3][0]= "R";mapa3[3][1]= "R";mapa3[3][2]= "R";mapa3[3][3]= "R";
         mapa3[3][6]= "R";mapa3[3][12]= "R";mapa3[3][14]= "R";
         mapa3[4][0]= "R";mapa3[4][1]= "R";mapa3[4][2]= "R";mapa3[4][6]= "R";
         mapa3[4][10]= "R";mapa3[4][12]= "R";mapa3[4][14]= "R";
         mapa3[5][0]= "R";mapa3[5][1]= "R";mapa3[5][5]= "R";
         mapa3[5][7]= "R";mapa3[5][14]= "R";
         mapa3[6][9]= "R";mapa3[6][12]= "R";mapa3[6][14]= "R";
         mapa3[7][1]= "R";mapa3[7][3]= "R";mapa3[7][5]= "R";mapa3[7][14]= "R";
         mapa3[8][3]= "R";
         mapa3[9][0]= "R";mapa3[9][2]= "R";mapa3[9][4]= "R";
         mapa3[9][8]= "R";mapa3[9][9]= "R";mapa3[9][11]= "R";
         mapa3[9][12]= "R";mapa3[9][13]= "R";
         mapa3[10][8]= "R";mapa3[10][9]= "R";mapa3[10][11]= "R";
         mapa3[11][2]= "R";mapa3[11][6]= "R";mapa3[11][8]= "R";mapa3[11][9]= "R";
         mapa3[11][11]= "R";mapa3[11][13]= "R";mapa3[11][14]= "R";
         mapa3[12][0]= "R";mapa3[12][4]= "R";mapa3[12][8]= "R";
         mapa3[12][9]= "R";mapa3[12][11]= "R";
         mapa3[13][2]= "R";mapa3[13][11]= "R";mapa3[13][12]= "R";mapa3[13][13]= "R";
         mapa3[14][0]= "R";mapa3[14][1]= "R";mapa3[14][4]= "R";
         mapa3[14][5]= "R";mapa3[14][6]= "R";mapa3[14][7]= "R";
         mapa3[14][8]= "R";mapa3[14][9]= "R";mapa3[14][11]= "R";
         mapa3[14][12]= "R";mapa3[14][13]= "R";mapa3[14][14]= "C";
         
         
      
        int indiceAleatorio = (int) (Math.random() * 3);

        if (indiceAleatorio == 0) {
            cargarMapaBase(mapa1);
        }
        else if (indiceAleatorio == 1) {
            cargarMapaBase(mapa2);
        }
        else {
            cargarMapaBase(mapa3);
        }
         
    }
    
    private void cargarMapaBase(String[][] mapaBase) {
    for (int fila = 0; fila < tamano; fila++) {
        for (int columna = 0; columna < tamano; columna++) {
            if (mapaBase[fila][columna] == null) {
                Casilla[fila][columna] = "?";       // oculto
                Contenido[fila][columna] = ".";     // vacío real
            } else {
                Casilla[fila][columna] = "?";       // oculto también
                Contenido[fila][columna] = mapaBase[fila][columna]; // roca u objeto real
            }
        }
      }
    }


    public String leerCasilla(int fila, int columna) {
    if (posicionValida(fila, columna)) {
        return Casilla[fila][columna];
    }
    return null;
}

    public void limpiarCasilla(int fila, int columna) {
    if (posicionValida(fila, columna)) {
        Casilla[fila][columna] = ".";
    }
}

    
     
}
