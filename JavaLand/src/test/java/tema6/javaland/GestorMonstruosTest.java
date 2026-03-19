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
    @Test
    public void testCrear() {
        GestorMonstruos instance = new GestorMonstruos();
        instance.crear();
        // Comprobación opcional: el array no debe ser null
        assertNotNull(instance.getMonstruo(0));
    }

    /**
     * Test of eliminarMonstruo method, of class GestorMonstruos.
     */
    @Test
    public void testEliminarMonstruos() {

    // Antes: tamaño n
    int tamañoAntes = gestor.monstruos.length;

    // Monstruo a eliminar
    Monstruo m = gestor.getMonstruo(0);
    String nombre = m.getNombre();

    gestor.eliminarMonstruo(nombre);

    // Después: tamaño n-1
    int tamañoDespues = gestor.monstruos.length;
    assertEquals(tamañoAntes - 1, tamañoDespues);

    // El monstruo eliminado ya no está
    boolean encontrado = false;
    for (Monstruo x : gestor.monstruos) {
        if (x.getNombre().equalsIgnoreCase(nombre)) {
            encontrado = true;
        }
    }

    assertFalse(encontrado);
}

    /**
     * Test of getMonstruo method, of class GestorMonstruos.
     */
     @Test
    public void testGetMonstruo() {
        Monstruo m = gestor.getMonstruo(0);

        assertNotNull(m);
        assertEquals("No muerto", m.getNombre());
    }

    // MÉTODO AUXILIAR PARA CONTAR MONSTRUOS NO NULOS
    private int contar(Monstruo[] arr) {
        int c = 0;
        for (Monstruo m : arr) {
            if (m != null) c++;
        }
        return c;
    }
}
    

