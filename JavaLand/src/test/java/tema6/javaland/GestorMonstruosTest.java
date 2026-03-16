/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tema6.javaland;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author PC
 */
public class GestorMonstruosTest {
    
    public GestorMonstruosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private GestorMonstruos gestor;
    
    @BeforeEach
    public void setUp() {
        gestor = new GestorMonstruos();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of crear method, of class GestorMonstruos.
     */
    @Disabled("No probrar testInsertar()")
    @Test
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
    @Test
    public void testEliminarMonstruo() {
        System.out.println("eliminarMonstruo");
        Monstruo antes = gestor.getMonstruo(0);
        gestor.eliminarMonstruo(antes.getNombre());
        Monstruo despues = gestor.getMonstruo(0);
        assertNull(despues);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMonstruo method, of class GestorMonstruos.
     */
    @Disabled("No probrar testInsertar()")
    @Test
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
