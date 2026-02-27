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
    // Atributos: ataque
    private int ataque;
  
    //constructor: crear un arma con nombre y ataque
    public Arma(String nombre, int ataque){
        super(nombre);
        this.ataque = ataque;
    }
    
    //metodos: para obtener los valores 
    // getAtaque()
    public String getNombre(){
        return nombre;
    }
    
    // getNombre
    public int getAtaque(){
        return ataque;
    }
    
    @Override
public boolean Equipar(Valiente valiente) {
    valiente.setArma(this);
    System.out.println("Te has equipado el arma: " + nombre + " (+" + ataque + " ataque)");
    return true;
}
    
}