package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class C_EstudianteTest {
    C_Estudiante estudiante;

    @Before
    public void setUp() {
        estudiante = new C_Estudiante(12345);
    }

    @Test
    public void testGetCarnet() {
        int esperado = 12345;
        int obtenido = estudiante.getCarnet();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testSetCarnet() {
        estudiante.setCarnet(67890);
        int esperado = 67890;
        int obtenido = estudiante.getCarnet();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testToString() {
        String esperado = "C_Estudiante{carnet=12345}";
        String obtenido = estudiante.toString();
        assertEquals(esperado, obtenido);
    }
}
