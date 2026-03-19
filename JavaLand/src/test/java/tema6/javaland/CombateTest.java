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
public class CombateTest {
    
    public CombateTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private Combate combate;
    private Valiente valiente;
    private Monstruo monstruo;
    
    @BeforeEach
    public void setUp(){
        combate = new Combate();
        valiente = new Valiente("Guerrero", 100, 10, 5, 8, 4);
        monstruo = new Monstruo("Orco", 100, 10, 5, 8, 4);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of iniciarCombate method, of class Combate.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testIniciarCombate() {
        System.out.println("iniciarCombate");
        Valiente valiente = null;
        Monstruo monstruo = null;
        Combate instance = new Combate();
        instance.iniciarCombate(valiente, monstruo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turno method, of class Combate.
     */
    @Test
    public void testTurnoAtaqueAcierta() {
        System.out.println("AtaqueAcierta");
        monstruo.setHabilidad(50);
        valiente.setDefensa(0);
        valiente.setEscudo(new Escudo("Toalla", 0));
        int vidaInicial = valiente.getVida();
        combate.turno(monstruo, valiente);
        assertTrue(valiente.getVida() < vidaInicial);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testTurnoAtaqueFalla() {
        System.out.println("AtaqueFalla");
        monstruo.setHabilidad(0);
        valiente.setDefensa(100);
        valiente.setEscudo(new Escudo("EscudoGoty", 100));
        int vidaInicial = valiente.getVida();
        combate.turno(monstruo, valiente);
        assertEquals(vidaInicial, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of combateTerminado method, of class Combate.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testCombateTerminado() {
        System.out.println("combateTerminado");
        Valiente valiente = null;
        Monstruo monstruo = null;
        Combate instance = new Combate();
        instance.combateTerminado(valiente, monstruo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
