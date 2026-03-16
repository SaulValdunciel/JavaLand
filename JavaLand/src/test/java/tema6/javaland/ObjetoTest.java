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
public class ObjetoTest {
    
    public ObjetoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private Valiente valiente;
    private Arma arma1;
    private Arma arma2;
    private Escudo escudo;

    @BeforeEach
    public void setUp() {
        valiente = new Valiente("guerrero", 100, 10, 5, 8, 4);

        arma1 = new Arma("Espada oxidada", 2);
        arma2 = new Arma("Espada de hierro", 5);
        escudo = new Escudo("Escudo de hierro", 3);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNombre method, of class Objeto.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Objeto instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Equipar method, of class Objeto.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testEquipar() {
        System.out.println("Equipar");
        Valiente valiente = null;
        Objeto instance = null;
        boolean expResult = false;
        boolean result = instance.Equipar(valiente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEquiparArmaAumentaAtaque() {
        System.out.println("EquiparArmaAumentaAtaque");
        arma1.Equipar(valiente);
        assertEquals("Espada oxidada", valiente.getArma().getNombre());
        assertEquals(2, valiente.getArma().getAtaque());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }

    @Test
    public void testEquiparEscudoAumentaDefensa() {
        System.out.println("EquiparEscudoAumentaDefensa");
        escudo.Equipar(valiente);
        assertEquals("Escudo de hierro", valiente.getEscudo().getNombre());
        assertEquals(3, valiente.getEscudo().getDefensa());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testEquiparDosArmasMantieneLaUltima() {
        System.out.println("EquiparDosArmasMantieneLaUltima");
        arma1.Equipar(valiente);
        arma2.Equipar(valiente);
        assertEquals("Espada de hierro", valiente.getArma().getNombre());
        assertEquals(5, valiente.getArma().getAtaque());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
