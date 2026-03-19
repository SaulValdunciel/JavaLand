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
public class InventarioTest {
    
    public InventarioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private Inventario inventario;
    private Objeto objeto;

    @BeforeEach
    public void setUp() {
        inventario = new Inventario();
        objeto = new Arma("Espada oxidada", 2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAgregarObjetoAumentaInventario() {
        System.out.println("AgregarObjetoAumentaInventario");
        int antes = contarObjetos(inventario.getMochila());
        boolean resultado = inventario.AgregarObjeto(objeto);
        int despues = contarObjetos(inventario.getMochila());
        assertTrue(resultado);
        assertEquals(antes + 1, despues);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testAgregarObjetoLoGuardaEnElArray() {
        System.out.println("AgregarObjetoLoGuardaEnElArray");
        inventario.AgregarObjeto(objeto);
        boolean encontrado = false;
        for (Objeto o : inventario.getMochila()) {
            if (o != null && o.getNombre().equals("Espada oxidada")) {
                encontrado = true;
            }
        }
        assertTrue(encontrado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    private int contarObjetos(Objeto[] mochila) {
        int contador = 0;
        for (Objeto o : mochila) {
            if (o != null) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Test of AgregarObjeto method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testAgregarObjeto() {
        System.out.println("AgregarObjeto");
        Objeto obj = null;
        Inventario instance = new Inventario();
        boolean expResult = false;
        boolean result = instance.AgregarObjeto(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of UsarObjeto method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testUsarObjeto() {
        System.out.println("UsarObjeto");
        String nombre = "";
        Valiente valiente = null;
        Inventario instance = new Inventario();
        String expResult = "";
        String result = instance.UsarObjeto(nombre, valiente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MostrarInventario method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testMostrarInventario() {
        System.out.println("MostrarInventario");
        Inventario instance = new Inventario();
        boolean expResult = false;
        boolean result = instance.MostrarInventario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TienePlantaCurativa method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testTienePlantaCurativa() {
        System.out.println("TienePlantaCurativa");
        Inventario instance = new Inventario();
        boolean expResult = false;
        boolean result = instance.TienePlantaCurativa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMochila method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetMochila() {
        System.out.println("getMochila");
        Inventario instance = new Inventario();
        Objeto[] expResult = null;
        Objeto[] result = instance.getMochila();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMochila method, of class Inventario.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetMochila() {
        System.out.println("setMochila");
        Objeto[] mochila = null;
        Inventario instance = new Inventario();
        instance.setMochila(mochila);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
