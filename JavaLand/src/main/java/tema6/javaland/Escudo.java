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
    // atributos: defensa
    private int defensa;
    
    //constructor: crear un escudo con nombre y defensa
    public Escudo(String nombre,int defensa){
       super(nombre);
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