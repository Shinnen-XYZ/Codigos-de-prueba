package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class C_AsistenciaTest {
    C_Asistencia asistencia;
    C_Estudiante estudiante;

    @Before
    public void setUp() {
        asistencia = new C_Asistencia();
        estudiante = new C_Estudiante(55555);
    }

    @Test
    public void testAddEstudiante() {
        asistencia.addEstudiante(estudiante);
        String esperado = "C_Asistencia{estudiantes=[C_Estudiante{carnet=55555}]}";
        String obtenido = asistencia.toString();
        assertEquals(esperado, obtenido);
    }

    @Test(expected = C_Asistencia.MyException.class)
    public void testAddEstudianteNull() {
        asistencia.addEstudiante(null);
    }

    @Test
    public void testToStringVacio() {
        String esperado = "C_Asistencia{estudiantes=[]}";
        String obtenido = asistencia.toString();
        assertEquals(esperado, obtenido);
    }

    @Test
    public void testMyExceptionToString() {
        C_Asistencia.MyException e = new C_Asistencia.MyException("Error de prueba");
        String esperado = "MyException: Error de prueba";
        String obtenido = e.toString();
        assertEquals(esperado, obtenido);
    }
}
