package service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class RubbertDuckTest {
    private Duck d1;
    private ByteArrayOutputStream coo;

    @Before
    public void before() throws Exception {
        d1 = new RubbertDuck();
        coo = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream(coo));
    }

    @Test
    public void testDisplay() {
        d1.display();
        assertTrue(coo.toString().toLowerCase().contains("squeak"));
    }
    @Test
    public void testSwim() {
        d1.swim();
        assertTrue(coo.toString().toLowerCase().contains("nadar"));
    }
    @Test
    public void testFly() {
        d1.performfly();
        assertTrue(coo.toString().toLowerCase().contains("volar"));
    }
    @Test
    public void testsqueak() {
        d1.
        assertTrue(coo.toString().contains("Squeak"));
    }

    @Test
    public void testToString() {
        String esperado = "mallardduck()";
        String obtenido = d1.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}