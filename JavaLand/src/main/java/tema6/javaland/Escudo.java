/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM102
 */
public class Escudo extends Objeto {
    // atributos: nombre y defensa
    private String nombre;
    private int defensa;
    
    //constructor 
    public Escudo(String nombre,int defensa){
        this.nombre = nombre;
        this.defensa = defensa;
    }
    //metodos: para obtener los valores 
    //getNombre
    public String getNombre(){
        return nombre;
    }
    
    //getDefensa
    public int getDefensa(){
        return defensa;
    }
}
