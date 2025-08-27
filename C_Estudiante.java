package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class C_AsistenciaTest {

    @Test
    public void testInicializacion() {
        C_Asistencia asistencia = new C_Asistencia();
        assertNotNull(asistencia.toString()); 
    }

    @Test
    public void testAddEstudiante() {
        C_Asistencia asistencia = new C_Asistencia();
        C_Estudiante estudiante = new C_Estudiante();
        asistencia.addEstudiante(estudiante);


        String resultado = asistencia.toString();
        assertTrue(resultado.contains("estudiantes"));
        assertTrue(resultado.contains("C_Estudiante"));
    }

    @Test
    public void testMultipleEstudiantes() {
        C_Asistencia asistencia = new C_Asistencia();
        C_Estudiante estudiante1 = new C_Estudiante();
        C_Estudiante estudiante2 = new C_Estudiante();

        asistencia.addEstudiante(estudiante1);
        asistencia.addEstudiante(estudiante2);

        String resultado = asistencia.toString();
        assertTrue(resultado.contains("C_Estudiante"));
    }
}
