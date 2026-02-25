/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM105
 */
public class Inventario implements InventarioInterface {
//Lista ARRAY para Guardar Objetos en el INVENTARIO

    private Objeto[] mochila;
    private final int OBJETOS_MAX = 999;
    

    

    public Inventario() {

        this.mochila = new Objeto[OBJETOS_MAX];
    }

    @Override
    public boolean AgregarObjeto(Objeto obj) {
        boolean validar = false;

        //Añadir objeto hueco libres
        for (int i = 0; i < mochila.length; i++) {

            if (mochila[i] == null) {

                mochila[i] = obj;

                validar = true;
                break;
            }
        }

        return validar;

    }

    @Override
public String UsarObjeto(String nombre, Valiente valiente) {

    // Recorremos la mochila
    for (int i = 0; i < mochila.length; i++) {

        // Comprobamos que no sea null y que el nombre coincida
        if (mochila[i] != null && mochila[i].getNombre().equalsIgnoreCase(nombre)) {
            
            // 1. Aplicamos el efecto del objeto (sirve tanto para equipar espada como para curar con planta)
            // Llama al método Equipar (asegúrate de que en las clases hijas sobrescribes este método con el efecto correcto)
            mochila[i].Equipar(valiente); 
            
            // 2. Comprobamos si el objeto es un CONSUMIBLE (la Planta)
            // Suponiendo que la clase que vas a crear se llame PlantaCurativa:
            if (mochila[i] instanceof PlantaCurativa) {
                
                // Como es consumible, lo borramos del inventario
                mochila[i] = null; 
                return "Has consumido: " + nombre + " y te has curado.";
                
            } else {
                
                // Si NO es una planta (será Escudo, Espada, etc.), no lo borramos
                return "Te has equipado: " + nombre;
            }
        }
    }
    
    // Si termina el for y no ha devuelto nada, es que no lo encontró
    return "No tienes el objeto " + nombre + " en tu mochila.";
}

    @Override
    public boolean MostrarInventario() {

        boolean hayObjetos = false;
        int i = 0;
        System.out.println("¡Obejtos Disponibles!");

        //Revisar los objetos del Invent
        while (i < mochila.length && mochila[i] != null) {
            
            System.out.println("-" + mochila[i].getNombre());
            
            hayObjetos = true;
            i++;
        }
        if (!hayObjetos) {
        System.out.println("El inventario está vacío.");
    }
    
    return hayObjetos;
}
    
    // Método para comprobar si hay alguna planta en el inventario
    public boolean TienePlantaCurativa() {
        int i = 0;
        
        // Usamos tu bucle while favorito: recorre mientras haya objetos
        while (i < mochila.length && mochila[i] != null) {
            
            // Si el objeto que estamos mirando es una PlantaCurativa...
            if (mochila[i] instanceof PlantaCurativa) {
                return true; // Devolvemos true y salimos del método
            }
            i++;
        }
        
        // Si ha mirado todos los objetos y no ha entrado al 'if' de arriba, no hay plantas
        return false; 
    }
    
    public Objeto[] getMochila() {
        return mochila;
    }

    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

    }
    
    
