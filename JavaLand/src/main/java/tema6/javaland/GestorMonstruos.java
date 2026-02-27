/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author cuent
 */
public class GestorMonstruos implements GestoresInterface {

    //array para guarfar niveles de monstruos
    private Monstruo[] monstruos;  //maximo 10

    //Constructor vacio
    public GestorMonstruos() {
        crear();
    }

    @Override
    public void crear() {

        monstruos = new Monstruo[10];
        
        //monstruos
        monstruos[0] = new Monstruo("No muerto", 35, 6, 3, 9, 7);
        monstruos[1] = new Monstruo("Kobold", 30, 7, 5, 0, 9);
        monstruos[2] = new Monstruo("Orco", 35, 13, 9, 1, 7);
        monstruos[3] = new Monstruo("Cubo Gelatinoso", 55, 4, 15, 2, 3);
        monstruos[4] = new Monstruo("Araña Gigante", 40,12,5,1,13);
        monstruos[5] = new Monstruo("Hombre Tigre", 40,2,6,15,10);
        monstruos[6] = new Monstruo("Tiefling", 50, 15, 8, 0, 15);
        
    }

    // monstruo con estadisticas segun el nivel
    public void GenerarMonstruo(int nivel) {

    }

    //Eliminar el ultimo monstruo derrotado
    public void eliminarMonstruo(String nombre) {

        for (int i = 0; i < monstruos.length; i++) {
            
            if (monstruos[i].getNombre().equalsIgnoreCase(nombre)) {
                
                monstruos[i]= null;
            }
        }
        
    }
    
    public Monstruo getMonstruo(int indice){
    
        return monstruos[indice];
    }

}
