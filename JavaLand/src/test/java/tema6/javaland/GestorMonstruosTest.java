/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tema6.javaland;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DAM102
 */
public class GestorMonstruosTest {

    private GestorMonstruos gestor;
    
    public GestorMonstruosTest() {
    
    }

    
    @BeforeEach
    public void setUp() {
    gestor = new GestorMonstruos();
    }
    
    

    /**
     * Test of crear method, of class GestorMonstruos.
     */
    @org.junit.jupiter.api.Test
    public void testCrear() {
        System.out.println("crear");
        GestorMonstruos instance = new GestorMonstruos();
        instance.crear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMonstruo method, of class GestorMonstruos.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarMonstruo() {
        System.out.println("eliminarMonstruo");
        String nombre = "";
        GestorMonstruos instance = new GestorMonstruos();
        instance.eliminarMonstruo(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonstruo method, of class GestorMonstruos.
     */
    @org.junit.jupiter.api.Test
    public void testGetMonstruo() {
        System.out.println("getMonstruo");
        int indice = 0;
        GestorMonstruos instance = new GestorMonstruos();
        Monstruo expResult = null;
        Monstruo result = instance.getMonstruo(indice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
