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
    private GestorValientes listaValientes;
    private GestorMonstruos monstruos;
    private Combate combate;
    private Valiente valiente;
    private Monstruo monstruo;
    private int contMonstruos;
    private GestorObjeto gestorObjeto;

    // Constructor
    public Juego(int tamanoMapa) {
        mapa = new Mapa(tamanoMapa, false);  // Crear mapa sin revelar todo o revelando
        valienteFila = 0;                    // Posicion inicial del valiente (fila 0)
        valienteColumna = 0;                 // Posicion inicial del valiente (columna 0)
        juegoActivo = true;                  // El juego esta activo

        mapa.mapas();                         // Cargar un mapa aleatorio con rocas
        mapa.generarYMostrarMapa(valienteFila, valienteColumna); // Mostrar mapa inicial

        //??
        listaValientes = new GestorValientes();
        monstruos = new GestorMonstruos();
        combate = new Combate();
        
        gestorObjeto = new GestorObjeto();
        gestorObjeto.crear();
    }

    // Metodo principal para iniciar el juego
    public void iniciarJuego() {

        System.out.println();
        System.out.println("  +===========================================+");
        System.out.println("  |       Bienvenido a La Tierra de los       |");
        System.out.println("  |             Codigos Olvidados!            |");
        System.out.println("  +===========================================+");
        System.out.println();
        creacionOEleccionValiente(); // Crear o elegir valiente

        while (juegoActivo) {
            mostrarMenuPrincipal(); // Mostrar opciones del menu
            System.out.print("Elige una opcion: ");
            //Captura la linea completa que el usuario escribe y la guarda y se reinicia cada vez, no hay qu cerrar ni limpiar
            String opcion = new Scanner(System.in).nextLine();//Captura la linea completa que el usuario escribe y la guarda y se reinicia cada vez no hay qu cerrar ni limpiar

            switch (opcion) {
                case "1" ->
                    mostrarValiente();   // Mostrar informacion del valiente
                case "2" ->
                    equiparObjeto();     // Equipar objeto desde inventario
                case "3" ->
                    mapa.mostrarMapa(valienteFila, valienteColumna); // Mostrar mapa
                case "4" ->
                    explorarMapa(); // Moverse y explorar mapa
                case "5" -> {
                    System.out.println("Saliendo del juego...");
                    juegoActivo = false; // Terminar juego
                }
                default ->
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // Metodo para crear o elegir valiente
    public void creacionOEleccionValiente() {
        
        String opcion = " ";
        
        while (!opcion.equalsIgnoreCase("elegir") || opcion.equalsIgnoreCase("crear")) {
            
            System.out.println("ELEGIR o CREAR valiente");
            opcion = new Scanner(System.in).nextLine().toLowerCase().trim();
        }
        
        switch (opcion) {
            
            case "crear" -> {

                //crear valiente y sobreescribir el array segun su clase
                valiente = listaValientes.getValiente(listaValientes.crear2());

                //mostrar valiente creado
                System.out.println("Su valiente: ");
                System.out.println(valiente.toString());
                
            }
            
            case "elegir" -> {

                //mostrar lista de valientes hechos
                listaValientes.mostrarLista();
                
                System.out.println("1 Guerrero\t 2 Paladin\t 3 Mago\t 4 Picaro ");
                
                int seleccion = new Scanner(System.in).nextInt();

                //asignar valiente de la lista al jugador
                valiente = listaValientes.getValiente(seleccion - 1);

                //mostrar valiente elegido
                System.out.println("Su valiente: ");
                System.out.println(valiente.toString());
                
            }
            
            default -> {
            
                System.out.println("default de elegir o crear");
            }
            
        }
        
        mapa.revelarAdyacentes(valienteFila, valienteColumna); // Revelar casilla inicial y adyacentes
        mapa.mostrarMapa(valienteFila, valienteColumna);       // Mostrar mapa inicial
    }

    // Mostrar menu principal
    public void mostrarMenuPrincipal() {
        System.out.println();
        System.out.println("  +================================+");
        System.out.println("  |       MENU  PRINCIPAL          |");
        System.out.println("  +================================+");
        System.out.println("  |  1.  Mostrar valiente          |");
        System.out.println("  |  2.  Equipar objeto            |");
        System.out.println("  |  3.  Mostrar mapa              |");
        System.out.println("  |  4.  Explorar mapa             |");
        System.out.println("  |  5.  Salir del juego           |");
        System.out.println("  +================================+");
        System.out.println();
    }

    // Mostrar informacion del valiente
    public void mostrarValiente() {
        //por si no hay valiente
        if (valiente == null) {
            System.out.println("No hay valiente creado todavía.");
            return;
        }
        //Llamamos a los metodos para ver las stats y demas
        System.out.println("\n===== INFORMACIÓN DEL VALIENTE =====");

        System.out.println(valiente);

        System.out.println("\n--- EQUIPAMIENTO ---");
        System.out.println("Arma: " + valiente.getArma().getNombre()
                + " (+" + valiente.getArma().getAtaque() + " ataque)");

        System.out.println("Escudo: " + valiente.getEscudo().getNombre()
                + " (+" + valiente.getEscudo().getDefensa() + " defensa)");

        System.out.println("\nDefensa total: " + valiente.getDefensaTotal());
        System.out.println("Cooldown habilidad: " + valiente.getCooldownHabilidad() + " turnos");

        System.out.println("\n--- INVENTARIO ---");
        valiente.getInventario().MostrarInventario();
    }

    // Equipar objeto 
    public void equiparObjeto() {
        //por si no hay valiente creao
        if (valiente == null) {
            System.out.println("Aún no hay valiente creado.");
            return;
        }

        System.out.println("\n===== INVENTARIO =====");

        boolean hay = valiente.getInventario().MostrarInventario();
        if (!hay) {
            return;
        }

        System.out.println("\nEscribe el nombre exacto del objeto que quieres usar/equipar");
        System.out.println("(o escribe X para cancelar)");
        System.out.print("Objeto: ");
        String nombre = teclado.nextLine();

        if (nombre.equalsIgnoreCase("x")) {
            System.out.println("Cancelado.");
            return;
        }

        // Usar / Equipar / Curar según el tipo real del objeto (Arma, Escudo, PlantaCurativa)
        String resultado = valiente.getInventario().UsarObjeto(nombre, valiente);
        System.out.println(resultado);
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
                String direccion = new Scanner(System.in).nextLine().toLowerCase();

                // Permitir salir del bucle de movimiento
                if (direccion.equalsIgnoreCase("x")) {
                    explorando = false;
                    System.out.println("Saliendo del modo de movimiento...");
                }

                // Calcular nueva posicion
                int nuevaFila = valienteFila;
                int nuevaColumna = valienteColumna;

                switch (direccion) {

                    case "w" ->
                        nuevaFila--;
                    case "s" ->
                        nuevaFila++;
                    case "a" ->
                        nuevaColumna--;
                    case "d" ->
                        nuevaColumna++;
                    default -> {
                        System.out.println("Direccion no valida.");
                        nuevaFila = valienteFila; // No moverse
                        nuevaColumna = valienteColumna;
                    }
                }

                // Solo intentar mover si hay cambio de posicion
                if (nuevaFila != valienteFila || nuevaColumna != valienteColumna) {

                    // Comprobar limites del mapa
                    if (mapa.posicionValida(nuevaFila, nuevaColumna)) {

                        // Comprobar si hay roca
                        String casillaDestino = mapa.leerCasilla(nuevaFila, nuevaColumna);
                        if (!casillaDestino.equals("R")) {

                            // Revisar contenido de la casilla
                            if (casillaDestino.equals("M")) {
                                System.out.println("Hay un monstruo");
                                System.out.print("¿Quieres atacar? (s/n): ");
                                String respuesta = new Scanner(System.in).nextLine().toLowerCase();
                                if (respuesta.equals("s")) {

                                    // mover jugador
                                    valienteFila = nuevaFila;
                                    valienteColumna = nuevaColumna;

                                    mapa.revelarAdyacentes(valienteFila, valienteColumna);

                                    System.out.println("Iniciando combate...");
                                    monstruo = monstruos.getMonstruo(contMonstruos);
                                    //iniciar combate
                                    combate.iniciarCombate(valiente, monstruo);

                                    if (valiente.getVida() == 0) {

                                        System.out.println("FIN DEL JUEGO");
                                        juegoActivo = false;
                                        explorando = false;

                                    } else {
                                        contMonstruos++;//aumentar el contador de monstuos derrotados
                                        mapa.limpiarCasilla(valienteFila, valienteColumna);
                                        explorando = false;

                                    }
                                } else {

                                    System.out.println("Decides no atacar. Permaneces en tu posicion.");
                                    valienteFila = valienteFila;// No moverse
                                    valienteColumna = valienteColumna;
                                }
                                
                            } else if (casillaDestino.equals("O")) {
                                valienteFila = nuevaFila;
                                valienteColumna = nuevaColumna;
                                mapa.revelarAdyacentes(valienteFila, valienteColumna);
                                System.out.println("Has encontrado un objeto.");

                                // ===== CAMBIO 3: recoger objeto y guardarlo en inventario =====
                                int indice = (int) (Math.random() * 7); // 0..6 (ajusta si tu gestor tiene otro tamaño)
                                Objeto encontrado = gestorObjeto.getObjeto(indice);
                                System.out.println(valiente.recogerObjeto(encontrado));

                                mapa.limpiarCasilla(valienteFila, valienteColumna);
                                explorando = false; // Salir del bucle de movimiento
                            } else if (casillaDestino.equals("C")) {
                                valienteFila = nuevaFila;
                                valienteColumna = nuevaColumna;
                                mapa.revelarAdyacentes(valienteFila, valienteColumna);
                                System.out.println("Te encuentras con el Jefe Final el Compilador Oscuro");
                                //iniciar combate
                                combate.iniciarCombate(valiente, monstruo);
                                mapa.limpiarCasilla(valienteFila, valienteColumna);
                                explorando = false; // Salir del bucle de movimiento
                                juegoActivo = false;
                            } else if (casillaDestino.equals(".")) {
                                valienteFila = nuevaFila;
                                valienteColumna = nuevaColumna;
                                mapa.revelarAdyacentes(valienteFila, valienteColumna);
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
                    if (!direccion.equals("w") && !direccion.equals("s") && !direccion.equals("a") && !direccion.equals("d")) {
                        // Direccion invalida ya impresa
                    } else {
                        System.out.println("No puedes moverte en esa direccion.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un numero");
            } catch (IllegalArgumentException e) {
                System.out.println("Opcion fuera del menu");
            } catch (NullPointerException e) {
                System.out.println("Acceder a array sin crearlo");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error Indice fuera del array");
            } catch (Exception e) {
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
