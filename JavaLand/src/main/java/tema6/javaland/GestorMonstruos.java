/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author M
 */
public class GestorMonstruos implements GestoresInterface {

    Monstruo[] monstruos;

    /**
     * Constructor que llama a crear() para generar la lista de monstruos
     *
     * @author Maya
     *
     */
    public GestorMonstruos() {
        crear();
    }

    /**
     * generar listado de monstruos
     *
     * @author Maya
     */
    @Override
    public void crear() {

        monstruos = new Monstruo[10];

        //monstruos
        monstruos[0] = new Monstruo("No muerto", 35, 6, 3, 11, 7);
        monstruos[1] = new Monstruo("Kobold", 30, 7, 5, 12, 9);
        monstruos[2] = new Monstruo("Orco", 35, 11, 9, 12, 7);
        monstruos[3] = new Monstruo("Cubo Gelatinoso", 55, 6, 10, 13, 3);
        monstruos[4] = new Monstruo("Araña Gigante", 40, 12, 5, 11, 13);
        monstruos[5] = new Monstruo("Hombre Tigre", 40, 2, 6, 15, 10);
        monstruos[6] = new Monstruo("Tiefling", 50, 14, 8, 15, 15);
        monstruos[7] = new Monstruo("Draconido", 50, 15, 9, 16, 13);
        monstruos[8] = new Monstruo("Aarakocra", 55, 16, 10, 14, 13);
        monstruos[9] = new Monstruo("Dragon rojo", 60, 18, 12, 15, 16);

    }

    /**
     * Borra un monstro del array
     *
     * @author Maya
     * @param nombre
     */
    public void eliminarMonstruo(String nombre) {
    Monstruo[] nuevo = new Monstruo[monstruos.length - 1];
    int j = 0;

    for (int i = 0; i < monstruos.length; i++) {
        if (!monstruos[i].getNombre().equalsIgnoreCase(nombre)) {
            nuevo[j] = monstruos[i];
            j++;
        }
    }

    monstruos = nuevo;
}


    /**
     *Devuelve el monstruo que se encuentra en el índice recibido por parámetro
     * @param indice
     * @return
     * @author Maya
     */
    public Monstruo getMonstruo(int indice) {

        return monstruos[indice];
    }

}
