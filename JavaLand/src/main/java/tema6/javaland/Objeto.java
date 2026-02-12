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
private String nombre;

    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    //Equipar Objeto
    @Override
    public boolean ObjetoEquipar() {
        System.out.println("Equipandose " + " al Valiente!");
        aplicarEfecto(valiente);
    }

    AbstractStringBuilder getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
