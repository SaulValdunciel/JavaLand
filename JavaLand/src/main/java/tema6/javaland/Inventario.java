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

    /**
     * Agregar Objeto donde se recorre el inventario buscando huecos libres
     *
     * @param obj
     * @return
     * @Author Sergio
     */
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

    /**
     * Recorrer la Mochila para Usar Objeto, Al usarlo el Inventario se ordena,
     * Objeto 2 Cosumido, El 3 pasa al 2
     *
     * @param nombre
     * @param valiente
     * @return
     * @Author Sergio, Saúl
     */
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
                        mochila[j] = mochila[j + 1];
                    }

                    return "Has consumido: " + nombre + " y te has curado.";

                } else {

                    return "Te has equipado: " + nombre;
                }
            }
        }

        // Si termina el for y no ha devuelto nada, es que no lo encontró
        return "No tienes el objeto " + nombre + " en tu mochila.";
    }

    /**
     * Mostrar el Inventario al valiente, Indicamiento de si esta vacio-hay
     * Plant. curativas
     *
     * @return
     * @Author Sergio, Saúl
     */
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

    /**
     * Compruba si tiene o no una planta curativa en el inventario
     * 
     * @return 
     * @author Saúl
     */
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
