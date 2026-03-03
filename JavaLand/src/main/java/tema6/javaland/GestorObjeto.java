/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM127
 */
public class GestorObjeto implements GestoresInterface {

    //array para crear los objetos que tendremos por el mapa
    private Objeto[] objetos = new Objeto[7]; //tendremos 7 objetos definidos

    //contructor por defecto
    public GestorObjeto() {

    }

    @Override
    public void crear() {
        objetos[0] = new Arma("Espada Desgastada", 2);
        objetos[1] = new Arma("Espada de Hierro", 5);
        objetos[2] = new Arma("Daga", 3);

        objetos[3] = new Escudo("Escudo Oxidado", 2);
        objetos[4] = new Escudo("Escudo de Hierro", 5);
        objetos[5] = new Escudo("Escudo Pequeño", 3);
        
        objetos[6] = new PlantaCurativa("Planta Curativa");
        
    }

    public Objeto getObjeto(int indice) {

        return objetos[indice];
    }
}
