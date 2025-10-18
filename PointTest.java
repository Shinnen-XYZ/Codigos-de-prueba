package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point p;

    @Before
    public void before() throws Exception {
        p = new Point(0,0);
    }

    @Test
    public void testSetPoint() {
        p.setPoint(1,2);
        String esperado = "[1.0, 2.0]";
        String obtenido = p.toString().toLowerCase();
        assertEquals( esperado, obtenido);
    }

    @Test
    public void testGetName() {
        String esperado = "[1.0, 2.0]";
        String obtenido = p.toString().toLowerCase();
        assertEquals( esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "punto";
        String obtenido = p.getName().toLowerCase();
        assertEquals( esperado, obtenido);
    }
}