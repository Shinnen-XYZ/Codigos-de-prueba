package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {
    private Circle C;

    @Before
    public void before() throws Exception {
        C = new Circle(1,3,4);
    }

    @Test
    public void setRadius() {
        double esperado = C.setPoint(1,2);
        double obtenido =C.radius ;
        assertEquals(esperado, obtenido);

    }

    @Test
    public void getRadius() {
    }

    @Test
    public void area() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void testToString() {
        String esperado = "centro = [3.0, 4.0]; radio = 1.0";
        String obtenido= C.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }
}