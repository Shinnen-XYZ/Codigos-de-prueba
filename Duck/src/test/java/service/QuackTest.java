package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class QuackTest {
    private SoundBehavior sb;
    private ByteArrayOutputStream out;

    @Before
    public void before() throws Exception {
        sb = new Quack();
        out = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream( out ));
    }

    @Test
    public void makeSound() {
        sb.makeSound();
        assertTrue(out.toString().toLowerCase().contains("quack quack"));
    }

    @Test
    public void testToString() {
        String esperado = "quack()";
        String obtenido = sb.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}