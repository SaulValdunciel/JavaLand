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
    
    // 1. Atributo para la curación
    private int puntosCuracion;

    // 2. Constructor
    public PlantaCurativa(String nombre, int puntosCuracion) {
        super(nombre); 
        this.puntosCuracion = puntosCuracion;
    }

    // 3. Método Equipar modificado para curar
    @Override
    public boolean Equipar(Valiente valiente) {
        
        // Sumamos la vida (ajusta "getVida" y "setVida" a los métodos reales que tengas)
        int nuevaVida = valiente.getVida() + puntosCuracion;
        valiente.setVida(nuevaVida);
        
        System.out.println("Te has comido " + this.nombre + " y has recuperado " + puntosCuracion + " de vida.");
                           
        return true; 
    }
}
