/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author DAM102
 */
public class Arma extends Objeto{
    // Atributos: nombre y ataque
    private String nombre;
    private int ataque;
    

    //constructor: crear un arma con nombre y ataque
    public Arma(String nombre, int ataque){
        this.nombre = nombre;
        this.ataque = ataque;
    }
    
    //metodos: para obtener los valores 
    // setAtaque()
    public String getNombre(){
        return nombre;
    }
    
    // setNombre
    public int getAtaque(){
        return ataque;
    }
}
