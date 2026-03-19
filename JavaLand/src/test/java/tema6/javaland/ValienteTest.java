/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tema6.javaland;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author DAM127
 */
public class ValienteTest {

    public ValienteTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    private Valiente valiente;

    @BeforeEach
    public void setUp() {
        valiente = new Valiente("Mago", 100, 10, 5, 8, 4);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of atacar method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testAtacar() {
        System.out.println("atacar");
        Object Personaje = null;
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.atacar(Personaje);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recibirDaño method, of class Valiente.
     */
    @Test
    public void testRecibirDaño() {
        System.out.println("recibirDaño");
        int cantidad = 20;
        int expResult = 80;
        int result = valiente.recibirDaño(cantidad);
        assertEquals(80, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRecibirDañoVidaCero() {
        System.out.println("recibirDaño en Cero");
        int cantidad = 100;
        int expResult = 0;
        int result = valiente.recibirDaño(cantidad);
        assertEquals(0, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRecibirDañoExcesivo() {
        System.out.println("recibirDañoExcesivo");
        int cantidad = 120;
        int expResult = 0;
        int result = valiente.recibirDaño(cantidad);
        assertEquals(0, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRecibirDañoCero() {
        System.out.println("recibirDañoCero");
        int cantidad = 0;
        int expResult = 100;
        int result = valiente.recibirDaño(cantidad);
        assertEquals(100, valiente.getVida());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ValienteUsarHabilidadEspecial method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testValienteUsarHabilidadEspecial() {
        System.out.println("ValienteUsarHabilidadEspecial");
        Valiente instance = new Valiente();
        boolean expResult = false;
        boolean result = instance.ValienteUsarHabilidadEspecial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValienteSubirNivel method, of class Valiente.
     */
    @Test
    public void testValienteSubirNivel() {
        System.out.println("ValienteSubirNivel");
        valiente.ValienteSubirNivel();
        assertEquals(2, valiente.getNivel());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testValienteSubirVida() {
        System.out.println("ValienteSubirNivel");
        valiente.ValienteSubirNivel();
        assertEquals(110, valiente.getVida());
        assertEquals(110, valiente.getVidaMaxima());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSubirNivelAumentaFuerzaEn1() {
        System.out.println("ValienteAumentaFuerzaEn1");
        valiente.ValienteSubirNivel();
        assertEquals(11, valiente.getFuerza());
    }

    @Test
    public void testSubirNivelAumentaDefensaEn1() {
        System.out.println("ValienteAumentaDefensaEn1");
        valiente.ValienteSubirNivel();
        assertEquals(6, valiente.getDefensa());
    }

    @Test
    public void testSubirNivelAumentaHabilidadEn1() {
        System.out.println("ValienteAumentaHabilidadEn1");
        valiente.ValienteSubirNivel();
        assertEquals(9, valiente.getHabilidad());
    }

    @Test
    public void testSubirNivelAumentaVelocidadEn1() {
        System.out.println("ValienteAumentaVelocidadEn1");
        valiente.ValienteSubirNivel();
        assertEquals(5, valiente.getVelocidad());
    }

    /**
     * Test of tickCooldown method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testTickCooldown() {
        System.out.println("tickCooldown");
        Valiente instance = new Valiente();
        instance.tickCooldown();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCooldownHabilidad method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetCooldownHabilidad() {
        System.out.println("getCooldownHabilidad");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getCooldownHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensaTotal method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetDefensaTotal() {
        System.out.println("getDefensaTotal");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getDefensaTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recogerObjeto method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testRecogerObjeto() {
        System.out.println("recogerObjeto");
        Objeto obj = null;
        Valiente instance = new Valiente();
        String expResult = "";
        String result = instance.recogerObjeto(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testToString() {
        System.out.println("toString");
        Valiente instance = new Valiente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInventario method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetInventario() {
        System.out.println("getInventario");
        Valiente instance = new Valiente();
        Inventario expResult = null;
        Inventario result = instance.getInventario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInventario method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetInventario() {
        System.out.println("setInventario");
        Inventario inventario = null;
        Valiente instance = new Valiente();
        instance.setInventario(inventario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClase method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetClase() {
        System.out.println("getClase");
        Valiente instance = new Valiente();
        String expResult = "";
        String result = instance.getClase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClase method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetClase() {
        System.out.println("setClase");
        String clase = "";
        Valiente instance = new Valiente();
        instance.setClase(clase);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVida method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetVida() {
        System.out.println("getVida");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getVida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVida method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetVida() {
        System.out.println("setVida");
        int vida = 0;
        Valiente instance = new Valiente();
        instance.setVida(vida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVidaMaxima method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetVidaMaxima() {
        System.out.println("getVidaMaxima");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getVidaMaxima();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVidaMaxima method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetVidaMaxima() {
        System.out.println("setVidaMaxima");
        int vidaMaxima = 0;
        Valiente instance = new Valiente();
        instance.setVidaMaxima(vidaMaxima);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuerza method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetFuerza() {
        System.out.println("getFuerza");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getFuerza();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFuerza method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetFuerza() {
        System.out.println("setFuerza");
        int fuerza = 0;
        Valiente instance = new Valiente();
        instance.setFuerza(fuerza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDefensa method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetDefensa() {
        System.out.println("getDefensa");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getDefensa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefensa method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetDefensa() {
        System.out.println("setDefensa");
        int defensa = 0;
        Valiente instance = new Valiente();
        instance.setDefensa(defensa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHabilidad method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetHabilidad() {
        System.out.println("getHabilidad");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getHabilidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHabilidad method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetHabilidad() {
        System.out.println("setHabilidad");
        int habilidad = 0;
        Valiente instance = new Valiente();
        instance.setHabilidad(habilidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocidad method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetVelocidad() {
        System.out.println("getVelocidad");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getVelocidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVelocidad method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetVelocidad() {
        System.out.println("setVelocidad");
        int velocidad = 0;
        Valiente instance = new Valiente();
        instance.setVelocidad(velocidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNivel method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetNivel() {
        System.out.println("getNivel");
        Valiente instance = new Valiente();
        int expResult = 0;
        int result = instance.getNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNivel method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetNivel() {
        System.out.println("setNivel");
        int nivel = 0;
        Valiente instance = new Valiente();
        instance.setNivel(nivel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArma method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetArma() {
        System.out.println("getArma");
        Valiente instance = new Valiente();
        Arma expResult = null;
        Arma result = instance.getArma();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArma method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetArma() {
        System.out.println("setArma");
        Arma arma = null;
        Valiente instance = new Valiente();
        instance.setArma(arma);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEscudo method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testGetEscudo() {
        System.out.println("getEscudo");
        Valiente instance = new Valiente();
        Escudo expResult = null;
        Escudo result = instance.getEscudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEscudo method, of class Valiente.
     */
    @Disabled("No probrar testInsertar()")
    @Test
    public void testSetEscudo() {
        System.out.println("setEscudo");
        Escudo escudo = null;
        Valiente instance = new Valiente();
        instance.setEscudo(escudo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
