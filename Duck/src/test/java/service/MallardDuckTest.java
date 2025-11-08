package service;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class MallardDuckTest {
    private Duck d1;
    private ByteArrayOutputStream coo;

    @Before
    public void before() throws Exception {
        d1 = new MallardDuck();
        coo = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream(coo));
    }

    @Test
    public void testDisplay() {
        d1.display();
        assertTrue(coo.toString().toLowerCase().contains("quak"));
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
    public void testQuack() {
        d1.Quack();
        assertTrue(coo.toString().contains("Quack"));
    }

    @Test
    public void testToString() {
        String esperado = "mallardduck()";
        String obtenido = d1.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}