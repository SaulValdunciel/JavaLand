/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM105
 */
public class Objeto implements ObjetoInterface {

    protected String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }
    //Equipar Objeto
    @Override
    public boolean ObjetoEquipar(Valiente valiente) {
        System.out.println("Equipandose " + " al Valiente!");
        return false;
        
    }

    public String getNombre() {
        return nombre;
    }

    

}
