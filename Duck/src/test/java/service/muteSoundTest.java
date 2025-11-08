package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class muteSoundTest {

    private SoundBehavior sb;
    private ByteArrayOutputStream out;

    @Before
    public void before() throws Exception {
        sb = new muteSound();
        out = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream( out ));
    }

    @Test
    public void makeSound() {
        sb.makeSound();
        assertTrue(out.toString().toLowerCase().contains("... ..."));
    }

    @Test
    public void testToString() {
        String esperado = "mutesound()";
        String obtenido = sb.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}