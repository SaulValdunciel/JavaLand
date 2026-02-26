/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.javaland;
/**
 *
 * @author DAM105
 */
public class PlantaCurativa extends Objeto {
    

    // 1. Constructor
    public PlantaCurativa(String nombre) {
        super(nombre); 
    }

    // 2. Método Equipar modificado para curar
    @Override
    public boolean Equipar(Valiente valiente) {

        // 1. Calculamos el 50% de esa vida máxima
        int curacion = valiente.getVidaMaxima() / 2; 
        
        // 2. Se lo sumamos y actualizamos la vida del Valiente actual
        int nuevaVida = valiente.getVida() + curacion;
        valiente.setVida(nuevaVida);
        
        System.out.println("Te has comido " + this.nombre + " y te has curado " + curacion + " puntos.");
                           
        return true;
    }
}
