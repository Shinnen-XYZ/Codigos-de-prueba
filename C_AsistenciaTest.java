package service;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class C_AsistenciaTest {
    private C_Asistencia asis;
    private C_Estudiante alum1;
    private C_Estudiante alum2;

    @Before
    public void setUp(){
        asis = new C_Asistencia();
        alum1 = new C_Estudiante();
        alum1.setCarnet(12345);
        alum2 = new C_Estudiante();
        alum2.setCarnet(67890);
    }

    @Test
    public void testToString() {
        String obtenido = asis.toString();
        assertTrue(obtenido.contains("C_Asistencia"));
    }

    @Test( expected = RuntimeException.class)
    public void testAddEstudianteNoNulo(){
        asis.addEstudiante(null);
    }

    @Test
    public void testAddEstudiante() {
        assertEquals(0, asis.cantidadEstudiantes());
        asis.addEstudiante(alum1);
        assertEquals(1, asis.cantidadEstudiantes());
    }

    @Test
    public void testGetEstudiantes() {
        asis.addEstudiante(alum1);
        List<C_Estudiante> lista = asis.getEstudiantes();
        assertEquals(1, lista.size());
    }

    @Test
    public void testSetEstudiantes() {
        List<C_Estudiante> nuevaLista = new ArrayList();
        nuevaLista.add(alum1);
        nuevaLista.add(alum2);
        
        asis.setEstudiantes(nuevaLista);
        assertEquals(2, asis.cantidadEstudiantes());
    }

    @Test
    public void testRemoveEstudiante() {
        asis.addEstudiante(alum1);
        assertEquals(1, asis.cantidadEstudiantes());
        
        asis.removeEstudiante(alum1);
        assertEquals(0, asis.cantidadEstudiantes());
    }

    @Test
    public void testBuscarPorCarnet() {
        asis.addEstudiante(alum1);
        
        C_Estudiante encontrado = asis.buscarPorCarnet(12345);
        assertNotNull(encontrado);
        assertEquals(12345, encontrado.getCarnet());
        
        C_Estudiante noEncontrado = asis.buscarPorCarnet(99999);
        assertNull(noEncontrado);
    }

    @Test
    public void testEstaVacia() {
        assertTrue(asis.estaVacia());
        asis.addEstudiante(alum1);
        assertFalse(asis.estaVacia());
    }
}
