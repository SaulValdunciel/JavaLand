/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;

/**
 *
 * @author M
 */
public class CompiladorOscuro extends Monstruo {


    /**
     *Constructor que crea al compilador oscuro multiplicando las estadisticas base 
     * por el nº de monstruos que hay en el mapa
     * 
     * @param nombre
     * @param vida
     * @param fuerza
     * @param defensa
     * @param habilidad
     * @param velocidad
     * @param NumMons
     * @author Maya
     */
    public CompiladorOscuro(String nombre, int vida, int fuerza, int defensa, int habilidad, int velocidad, int NumMons) {
        super(nombre, 150, fuerza * NumMons,
                defensa * NumMons, habilidad * NumMons, velocidad * NumMons);

    }

    /**
     *Mismo funcionamiento que el de monstruos
     * @param <T>
     * @param personaje
     * @return
     * @author Maya
     */
    @Override
    public <T> int atacar(T personaje) {
        return super.atacar(personaje);
    }

    /**
     * 
     * @param cantidad
     * @return 
     * @author Maya
     * 
     */
    @Override
    public int recibirDaño(int cantidad) {
        return super.recibirDaño(cantidad);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //getters y setters
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    @Override
    public int getHabilidad() {
        return habilidad;
    }

    @Override
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
