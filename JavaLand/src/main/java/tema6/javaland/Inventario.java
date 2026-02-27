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
    private final int OBJETOS_MAX = 10;

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

                mochila[i].Equipar(valiente);

                if (mochila[i] instanceof PlantaCurativa) {

                    // Como es consumible, lo borramos del inventario
                    
                    mochila[i] = null;
                    //For para que el Inventario sea Ordenado Automa.
                    for (int j = i; j < mochila.length - 1; j++) {
                    mochila[j] = mochila[j + 1]; }
                    
                    return "Has consumido: " + nombre + " y te has curado.";

                } else {

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
        System.out.println("¡Objetos disponibles!");

        for (int i = 0; i < mochila.length; i++) {
            if (mochila[i] != null) {
                System.out.println("- " + mochila[i].getNombre());
                hayObjetos = true;
            }
        }

        if (!hayObjetos) {
            System.out.println("El inventario está vacío.");
        }
        return hayObjetos;
    }

    // Método para comprobar si hay alguna planta en el inventario
    public boolean TienePlantaCurativa() {
        for (int i = 0; i < mochila.length; i++) {
            if (mochila[i] instanceof PlantaCurativa) {
                return true;
            }
        }
        return false;
    }

    public Objeto[] getMochila() {
        return mochila;
    }

    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

}
