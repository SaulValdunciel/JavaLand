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


    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean Equipar(Valiente valiente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
