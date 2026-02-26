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
        objetos[0] = new Objeto("Espada desgastda");
        objetos[1] = new Objeto("Espada de Hierro");
        objetos[2] = new Objeto("Espada de Hierro");
        objetos[3] = new Objeto("Escudo oxidado");
        objetos[4] = new Objeto("Escudo de Hierro");
        objetos[5] = new Objeto("Espada de Hierro");
        objetos[6] = new Objeto("Planta Curativa");

    }
    
     public Objeto getObjeto(int indice){
    
        return objetos[indice];
    }
}
