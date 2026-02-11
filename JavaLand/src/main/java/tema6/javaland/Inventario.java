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
    private final int OBJETOS_MAX = 12;

    public Inventario() {

        this.mochila = new Objeto[OBJETOS_MAX];
    }

    @Override
    public boolean InventarioAgregarObjeto() {
        //Buscar hueco libre
        int huecolibre = -1;
        for (int i = 0; i < mochila.length; i++) {

            if (mochila[i] == null) {

                huecolibre = i;
                break;
            }
        }
        //Si el Inventario esta lleno
        if (huecolibre == -1) {

            System.out.println("¡Echa Pa´tras mostro, Inventario Lleno");

        }
        return false;
        //Guardar Objeto
    }

    @Override
    public String InventarioUsarObjeto(String[] args) {

    }

    @Override
    public boolean InventarioMostrarInventario() {

    }

}
