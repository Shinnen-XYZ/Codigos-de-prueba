package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

public class FlyNoWayTest {

    private FlyBehavior fb;
    private ByteArrayOutputStream out;

    @Before
    public void before() throws Exception {
        fb = new FLyWithWings();
        out = new ByteArrayOutputStream();
        System.setOut( new java.io.PrintStream( out ));
    }

    @Test
    public void fly() {
        fb.fly();
        assertTrue(out.toString().toLowerCase().contains("puedo volar"));
    }
}