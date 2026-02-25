/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;
/**
 *
 * @author DAM105
 */
public class PlantaCurativa extends Objeto{
    // Atributos: ataque
    private int ataque;
  
    //constructor: crear un arma con nombre y ataque
    public PlantaCurativa(String nombre, int ataque){
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
}
