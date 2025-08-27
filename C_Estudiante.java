package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class C_AsistenciaTest {

    @Test
    public void testGetterEstudiantes() {
        C_Asistencia asistencia = new C_Asistencia();
        assertNotNull(asistencia.getEstudiantes());
        assertEquals(0, asistencia.getEstudiantes().size());
    }

    @Test
    public void testSetterEstudiantes() {
        C_Asistencia asistencia = new C_Asistencia();
        List<C_Estudiante> lista = new ArrayList<>();
        lista.add(new C_Estudiante());
        asistencia.setEstudiantes(lista);

        assertEquals(1, asistencia.getEstudiantes().size());
    }

    @Test
    public void testAddEstudiante() {
        C_Asistencia asistencia = new C_Asistencia();
        C_Estudiante estudiante = new C_Estudiante();
        asistencia.addEstudiante(estudiante);

        assertEquals(1, asistencia.getEstudiantes().size());
    }

    @Test
    public void testToString() {
        C_Asistencia asistencia = new C_Asistencia();
        asistencia.addEstudiante(new C_Estudiante());
        String resultado = asistencia.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("estudiantes"));
        assertTrue(resultado.contains("C_Estudiante"));
    }
}
