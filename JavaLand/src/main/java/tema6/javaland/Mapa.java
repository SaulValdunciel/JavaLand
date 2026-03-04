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
    
    private int monstruos;
    private int objetos;

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
                Casilla[fila][columna] = revelarTodo ? "\u25CF" : "\u25A1";
                Contenido[fila][columna] = "\u25CF"; // todo vacío inicialmente
            }
        }
        monstruos = 10;
        objetos = 6;
    }

    public int getMonstruos() {
        return monstruos;
    }

    public int getObjetos() {
        return objetos;
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
        if (posicionValida(fila, columna) && Casilla[fila][columna].equals("\u25A1")) {
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
            Contenido[fila][columna] = "\u2620";
        }
    }

    //Coloca un objeto en el mapa
    public void ponerObjeto(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            Contenido[fila][columna] = "\u2606";
        }
    }

    //Coloca un Rocas en el mapa
    public void ponerRocas(int fila, int columna) {
        if (posicionValida(fila, columna)) {
            Contenido[fila][columna] = "\u2617";
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
                    System.out.print(" \u26F9 ");
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
        if (!Contenido[fila][columna].equals("\u25CF")|| (fila == 0 && columna == 0) ) {
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
            if(!Casilla[fila -1][columna].equals("\u25CF")){
                return true;
            }
        }
        if(fila < tamano -1){
            if(!Casilla[fila +1][columna].equals("\u25CF")){
                return true;
            }
        }
        if(columna > 0){
            if(!Casilla[fila][columna -1].equals("\u25CF")){
                return true;
            }
        }
        if(columna < tamano -1){
            if(!Casilla[fila][columna +1].equals("\u25CF")){
                return true;
            }
        }
        return false;
    }
     public void generarYMostrarMapa(int valienteFila, int valienteColumna) {
    // colocar monstruos y objetos aleatorios solo si la casilla esta oculta
    int monstruos = 10;
    int objetos = 6;

    colocarElementos("\u2620", monstruos, false);
    colocarElementos("\u2606", objetos, false);

    // revelar la posicion inicial y adyacentes
    revelarAdyacentes(valienteFila, valienteColumna);

    // mostrar mapa inicial
    //mostrarMapa(valienteFila, valienteColumna);
}

    
    //Metodo de mapas creados a mano que ponen las rocas
    public void mapas(){
        String[][] mapa1 = new String[tamano][tamano];
        String[][] mapa2 = new String[tamano][tamano];
        String[][] mapa3 = new String[tamano][tamano];
    
    
         mapa1[0][2]= "\u2617";
         mapa1[1][2]= "\u2617";mapa1[1][3]= "\u2617";mapa1[1][9]= "\u2617";
         mapa1[1][11]= "\u2617";mapa1[1][14]= "\u2617";
         mapa1[2][6]= "\u2617";mapa1[2][11]= "\u2617";
         mapa1[3][1]= "\u2617";mapa1[3][4]= "\u2617";mapa1[3][6]= "\u2617";
         mapa1[3][11]= "\u2617";mapa1[3][14]= "\u2617";
         mapa1[4][2]= "\u2617";mapa1[4][8]= "\u2617";
         mapa1[5][6]= "\u2617";mapa1[5][10]= "\u2617";mapa1[5][14]= "\u2617";
         mapa1[6][3]= "\u2617";mapa1[6][6]= "\u2617";mapa1[6][13]= "\u2617";
         mapa1[7][8]= "\u2617";mapa1[7][9]= "\u2617";mapa1[7][10]= "\u2617";
         mapa1[8][1]= "\u2617";mapa1[8][7]= "\u2617";mapa1[8][8]= "\u2617";
         mapa1[8][9]= "\u2617";mapa1[8][10]= "\u2617";mapa1[8][11]= "\u2617";mapa1[8][13]= "\u2617";
         mapa1[9][8]= "\u2617";mapa1[9][9]= "\u2617";mapa1[9][10]= "\u2617";mapa1[9][13]= "\u2617";
         mapa1[10][4]= "\u2617";mapa1[10][6]= "\u2617";mapa1[10][9]= "\u2617";
         mapa1[11][2]= "\u2617";mapa1[11][4]= "\u2617";
         mapa1[12][6]= "\u2617";mapa1[12][11]= "\u2617";mapa1[12][13]= "\u2617";
         mapa1[13][11]= "\u2617";
         mapa1[14][4]= "\u2617";mapa1[14][7]= "\u2617";mapa1[14][14]= "\u265A";

         
         
         mapa2[0][2]= "\u2617";mapa2[0][3]= "\u2617";mapa2[0][4]= "\u2617";mapa2[0][5]= "\u2617";
         mapa2[1][0]= "\u2617";mapa2[1][2]= "\u2617";mapa2[1][3]= "\u2617";
         mapa2[1][8]= "\u2617";mapa2[1][11]= "\u2617";
         mapa2[2][0]= "\u2617";mapa2[2][8]= "\u2617";
         mapa2[3][0]= "\u2617";mapa2[3][3]= "\u2617";mapa2[3][4]= "\u2617";
         mapa2[3][7]= "\u2617";mapa2[3][8]= "\u2617";mapa2[3][9]= "\u2617";
         mapa2[3][11]= "\u2617";mapa2[3][12]= "\u2617";mapa2[3][13]= "\u2617";
         mapa2[4][0]= "\u2617";mapa2[4][3]= "\u2617";mapa2[4][4]= "\u2617";
         mapa2[4][8]= "\u2617";mapa2[4][13]= "\u2617";
         mapa2[5][0]= "\u2617";mapa2[5][2]= "\u2617";mapa2[5][3]= "\u2617";
         mapa2[5][4]= "\u2617";mapa2[5][11]= "\u2617";mapa2[5][13]= "\u2617";
         mapa2[6][0]= "\u2617";mapa2[6][5]= "\u2617";mapa2[6][13]= "\u2617";
         mapa2[7][0]= "\u2617";mapa2[7][8]= "\u2617";mapa2[7][11]= "\u2617";
         mapa2[8][0]= "\u2617";mapa2[8][3]= "\u2617";mapa2[8][7]= "\u2617";
         mapa2[8][8]= "\u2617";mapa2[8][9]= "\u2617";mapa2[8][13]= "\u2617";
         mapa2[9][0]= "\u2617";mapa2[9][6]= "\u2617";mapa2[9][7]= "\u2617";mapa2[9][8]= "\u2617";
         mapa2[9][9]= "\u2617";mapa2[9][10]= "\u2617";mapa2[9][13]= "\u2617";
         mapa2[10][0]= "\u2617";mapa2[10][1]= "\u2617";mapa2[10][3]= "\u2617";
         mapa2[10][7]= "\u2617";mapa2[10][8]= "\u2617";mapa2[10][9]= "\u2617";
         mapa2[10][13]= "\u2617";mapa2[10][14]= "\u2617";
         mapa2[11][0]= "\u2617";mapa2[11][5]= "\u2617";mapa2[11][8]= "\u2617";mapa2[11][11]= "\u2617";
         mapa2[12][0]= "\u2617";mapa2[12][4]= "\u2617";mapa2[12][5]= "\u2617";mapa2[12][6]= "\u2617";
         mapa2[13][0]= "\u2617";mapa2[13][8]= "\u2617";mapa2[13][10]= "\u2617";mapa2[13][13]= "\u2617";
         mapa2[14][0]= "\u2617";mapa2[14][1]= "\u2617";mapa2[14][2]= "\u2617";mapa2[14][5]= "\u2617";
         mapa2[14][6]= "\u2617";mapa2[14][9]= "\u2617";mapa2[14][10]= "\u2617";
         mapa2[14][11]= "\u2617";mapa2[14][12]= "\u2617";mapa2[14][13]= "\u2617";mapa2[14][14]= "\u265A";

         
         
         mapa3[0][5]= "\u2617";mapa3[0][6]= "\u2617";mapa3[0][7]= "\u2617";mapa3[0][8]= "\u2617";
         mapa3[0][9]= "\u2617";mapa3[0][10]= "\u2617";mapa3[0][11]= "\u2617";
         mapa3[0][12]= "\u2617";mapa3[0][13]= "\u2617";mapa3[0][14]= "\u2617";
         mapa3[1][3]= "\u2617";mapa3[1][5]= "\u2617";mapa3[1][14]= "\u2617";
         mapa3[2][3]= "\u2617";mapa3[2][9]= "\u2617";mapa3[2][11]= "\u2617";
         mapa3[2][13]= "\u2617";mapa3[2][14]= "\u2617";
         mapa3[3][0]= "\u2617";mapa3[3][1]= "\u2617";mapa3[3][2]= "\u2617";mapa3[3][3]= "\u2617";
         mapa3[3][6]= "\u2617";mapa3[3][12]= "\u2617";mapa3[3][14]= "\u2617";
         mapa3[4][0]= "\u2617";mapa3[4][1]= "\u2617";mapa3[4][2]= "\u2617";mapa3[4][6]= "\u2617";
         mapa3[4][10]= "\u2617";mapa3[4][12]= "\u2617";mapa3[4][14]= "\u2617";
         mapa3[5][0]= "\u2617";mapa3[5][1]= "\u2617";mapa3[5][5]= "\u2617";
         mapa3[5][7]= "\u2617";mapa3[5][14]= "\u2617";
         mapa3[6][9]= "\u2617";mapa3[6][12]= "\u2617";mapa3[6][14]= "\u2617";
         mapa3[7][1]= "\u2617";mapa3[7][3]= "\u2617";mapa3[7][5]= "\u2617";mapa3[7][14]= "\u2617";
         mapa3[8][3]= "\u2617";
         mapa3[9][0]= "\u2617";mapa3[9][2]= "\u2617";mapa3[9][4]= "\u2617";
         mapa3[9][8]= "\u2617";mapa3[9][9]= "\u2617";mapa3[9][11]= "\u2617";
         mapa3[9][12]= "\u2617";mapa3[9][13]= "\u2617";
         mapa3[10][8]= "\u2617";mapa3[10][9]= "\u2617";mapa3[10][11]= "\u2617";
         mapa3[11][2]= "\u2617";mapa3[11][6]= "\u2617";mapa3[11][8]= "\u2617";mapa3[11][9]= "\u2617";
         mapa3[11][11]= "\u2617";mapa3[11][13]= "\u2617";mapa3[11][14]= "\u2617";
         mapa3[12][0]= "\u2617";mapa3[12][4]= "\u2617";mapa3[12][8]= "\u2617";
         mapa3[12][9]= "\u2617";mapa3[12][11]= "\u2617";
         mapa3[13][2]= "\u2617";mapa3[13][11]= "\u2617";mapa3[13][12]= "\u2617";mapa3[13][13]= "\u2617";
         mapa3[14][0]= "\u2617";mapa3[14][1]= "\u2617";mapa3[14][4]= "\u2617";
         mapa3[14][5]= "\u2617";mapa3[14][6]= "\u2617";mapa3[14][7]= "\u2617";
         mapa3[14][8]= "\u2617";mapa3[14][9]= "\u2617";mapa3[14][11]= "\u2617";
         mapa3[14][12]= "\u2617";mapa3[14][13]= "\u2617";mapa3[14][14]= "\u265A";

         
         
      
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
                Casilla[fila][columna] = "\u25A1";       // oculto
                Contenido[fila][columna] = "\u25CF";     // vacío real
            } else {
                Casilla[fila][columna] = "\u25A1";       // oculto también
                Contenido[fila][columna] = mapaBase[fila][columna]; // roca u objeto real
            }
        }
      }
    }


    public String leerCasilla(int fila, int columna) {
    if (posicionValida(fila, columna)) {
        return Contenido[fila][columna];
    }
    return null;
}

    public void limpiarCasilla(int fila, int columna) {
    if (posicionValida(fila, columna)) {
        Casilla[fila][columna] = "\u25CF";
        Contenido[fila][columna] = "\u25CF";
    }
}

    
     
}
