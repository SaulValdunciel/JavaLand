/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author M
 */
public class CompiladorOscuro {
    private String nombre;
    private int vida; 
    private int fuerza; 
    private int defensa; 
    private int habilidad; 
    private int velocidad; 



    public CompiladorOscuro(int NumMonstruos) {//cada estadistica suma 3 puntos por monstruo generado
        
        nombre = "Compilador Oscuro";
        vida = 150;
        fuerza = 3 * NumMonstruos;
        defensa = 3 * NumMonstruos;
        habilidad = 3 * NumMonstruos;
        velocidad = 3 * NumMonstruos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    
    
    
}
