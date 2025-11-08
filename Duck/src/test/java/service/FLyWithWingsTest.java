package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;



public class FLyWithWingsTest {
    private FlyBehavior fb;
    private ByteArrayOutputStream out;

    @Before
    public void before() throws Exception {
        fb = new FLyWithWings();
        out = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream( out ));
    }

    @Test
    public void testFly() {
        fb.fly();
        String esperado = "puedo volar";
        String obtenido = out.toString().toLowerCase().trim();
        assertEquals(esperado, obtenido);
    }
    @Test
    public void testFlyII() {
        fb.fly();
        assertTrue(out.toString().toLowerCase().contains("puedo volar"));
    }

    @Test
    public void testToString() {
        String esperado = "flywithwings()";
        String obtenido = fb.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}