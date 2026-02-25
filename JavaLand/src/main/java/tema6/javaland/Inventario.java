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

        for (int i = 0; i < mochila.length; i++) {

        }
        return null;
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
    
    public Objeto[] getMochila() {
        return mochila;
    }

    public void setMochila(Objeto[] mochila) {
        this.mochila = mochila;
    }

    }
    
    
