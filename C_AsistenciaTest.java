package service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class C_AsistenciaTest {
    private C_Asistencia asis;
    private C_Estudiante Alum1;
    private C_Estudiante Alum2;

    @Before
    public void before() throws Exception{
        asis = new C_Asistencia();

    }

    @Before
    public void setUp(){
        Alum1 = new C_Estudiante();
    }

    @Test
    public void testToString() {
        String esperado = "c_asistencia(estudiantes=[])";
        String obtenido = asis.toString().toLowerCase();
        assertEquals(esperado, obtenido);
    }

    @Test( expected = RuntimeException.class)
    public void testAddEStudianteNoNulo(){
        asis.addEstudiante(null);
    }


    @Test
    public void addEstudiante() {

    }

    @Test
    public void getEstudiantes() {
        C_Estudiante esperado = new C_Estudiante();
    }

    @Test
    public void setEstudiantes() {

    }


}