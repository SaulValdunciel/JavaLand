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
    

    // 2. Constructor
    public PlantaCurativa(String nombre) {
        super(nombre); 
    }

    // 3. Método Equipar modificado para curar
    @Override
    public boolean Equipar(Valiente valiente) {
        
        // 1. Obtenemos la vida que tiene en este momento
        int vidaActual = valiente.getVida();
        
        // 2. Calculamos el 50% de esa vida
        int curacion = vidaActual / 2; 
        
        // 3. Se lo sumamos y actualizamos la vida del Valiente
        int nuevaVida = vidaActual + curacion;
        valiente.setVida(nuevaVida);
        
        System.out.println("Te has comido " + this.nombre + " y te has curado " + curacion + " puntos (50% de tu vida).");
                           
        return true;
    }
}
