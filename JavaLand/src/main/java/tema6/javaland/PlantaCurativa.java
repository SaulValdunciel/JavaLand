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
    

    //Constructor
    public PlantaCurativa(String nombre) {
        super(nombre); 
    }

    // Método Equipar modificado para curar un % de su vida máxima
    @Override
    public boolean Equipar(Valiente valiente) {

        // Calculamos el 50% de esa vida máxima
        int curacion = valiente.getVidaMaxima() / 2; 
        
        // Se lo sumamos y actualizamos la vida del Valiente actual
        int nuevaVida = valiente.getVida() + curacion;
        
        //Comprobamos si es mayor o no la nueva vida para que no pueda ser mayor a la máxima
         
        if (nuevaVida > valiente.getVidaMaxima()) {
            nuevaVida = valiente.getVidaMaxima();
        }
        
        valiente.setVida(nuevaVida);
        
        System.out.println("Te has comido " + this.nombre + " y te has curado " + curacion + " puntos.");
                           
        return true;
    }
}
