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
public class MonstruoTest {
    
    public MonstruoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private Monstruo monstruo;
    private Valiente valiente;
    
    @BeforeEach
    public void setUp() {
        monstruo = new Monstruo("Orco", 100, 10, 5, 8, 4);
        valiente = new Valiente("Guerrero", 100, 10, 5, 8, 4);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of atacar method, of class Monstruo.
     */
    @Test
    public void testAtacarPuedeHacerDaño() {
        System.out.println("atacar");
        int daño = monstruo.atacar(valiente);
        assertTrue(daño >= 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testAtacarPuedeFallar() {
        System.out.println("fallo ataque");
        valiente.setDefensa(100);
        int daño = monstruo.atacar(valiente);
        assertEquals(0, daño);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDaño method, of class Monstruo.
     */
    @Test
    public void testRecibirDaño() {
        System.out.println("recibirDaño");
        int result = monstruo.recibirDaño(20);
        assertEquals(80, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRecibirDañoExcesivo() {
        System.out.println("recibirDañoExcesivo");
        int result = monstruo.recibirDaño(150);
        assertEquals(-50, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRecibirDañoCero() {
        System.out.println("recibirDañoCero");
        int result = monstruo.recibirDaño(0);
        assertEquals(100, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testRecibirDañoDejarACero() {
        System.out.println("recibirDañoDejarACero");
        int result = monstruo.recibirDaño(100);
        assertEquals(0, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subirNivel method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSubirNivel() {
        System.out.println("subirNivel");
        Monstruo instance = null;
        instance.subirNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuerza method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetFuerza() {
        System.out.println("getFuerza");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getFuerza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensa method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetDefensa() {
        System.out.println("getDefensa");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHabilidad method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetHabilidad() {
        System.out.println("getHabilidad");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNivel method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetNivel() {
        System.out.println("getNivel");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVida method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetVida() {
        System.out.println("getVida");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getVida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocidad method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetVelocidad() {
        System.out.println("getVelocidad");
        Monstruo instance = null;
        int expResult = 0;
        int result = instance.getVelocidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Monstruo instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Monstruo instance = null;
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVida method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetVida() {
        System.out.println("setVida");
        int vida = 0;
        Monstruo instance = null;
        instance.setVida(vida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFuerza method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetFuerza() {
        System.out.println("setFuerza");
        int fuerza = 0;
        Monstruo instance = null;
        instance.setFuerza(fuerza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefensa method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetDefensa() {
        System.out.println("setDefensa");
        int defensa = 0;
        Monstruo instance = null;
        instance.setDefensa(defensa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilidad method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetHabilidad() {
        System.out.println("setHabilidad");
        int habilidad = 0;
        Monstruo instance = null;
        instance.setHabilidad(habilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocidad method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetVelocidad() {
        System.out.println("setVelocidad");
        int velocidad = 0;
        Monstruo instance = null;
        instance.setVelocidad(velocidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNivel method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetNivel() {
        System.out.println("setNivel");
        int nivel = 0;
        Monstruo instance = null;
        instance.setNivel(nivel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testToString() {
        System.out.println("toString");
        Monstruo instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValienteUsarHabilidadEspecial method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testValienteUsarHabilidadEspecial() {
        System.out.println("ValienteUsarHabilidadEspecial");
        Monstruo instance = null;
        boolean expResult = false;
        boolean result = instance.ValienteUsarHabilidadEspecial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValienteSubirNivel method, of class Monstruo.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testValienteSubirNivel() {
        System.out.println("ValienteSubirNivel");
        Monstruo instance = null;
        instance.ValienteSubirNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
