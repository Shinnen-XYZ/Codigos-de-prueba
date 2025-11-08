package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class RedHeadDuckTest {
    private Duck d2;
    private ByteArrayOutputStream coo;

    @Before
    public void before() throws Exception {
        d2 = new RedHeadDuck();
        coo = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream(coo));
    }

    @Test
    public void testDisplay() {
        d2.display();
        assertTrue(coo.toString().toLowerCase().contains("quak"));
    }
    @Test
    public void testSwim() {
        d2.swim();
        assertTrue(coo.toString().toLowerCase().contains("nadar"));
    }
    @Test
    public void testFly() {
        d2.performfly();
        assertTrue(coo.toString().toLowerCase().contains("volar"));
    }
    @Test
    public void testQuack() {
        d2.Quack();
        assertTrue(coo.toString().contains("Quack"));
    }

    @Test
    public void testToString() {
        String esperado = "redheadduck()";
        String obtenido = d2.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}