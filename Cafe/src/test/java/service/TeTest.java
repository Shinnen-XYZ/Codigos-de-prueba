package service;

import excepcion.ExcepcionPreparacion;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class TeTest {
    private Te te;
    private ByteArrayOutputStream salidaConsola;

    @Before
    public void before() {
        te = new Te("Verde");
        salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));
    }

    @Test
    public void testTeConstructorPorDefecto() {
        Te teDefecto = new Te();
        assertEquals("Verde", teDefecto.getTipoTe());
        assertEquals(80, teDefecto.getTemperatura());
        assertEquals(3, teDefecto.getTiempoPreparacion());
        assertEquals(3, teDefecto.getTiempoInfusion());
    }

    @Test
    public void testTeConTipoNegro() {
        Te teNegro = new Te("Negro");
        assertEquals("Negro", teNegro.getTipoTe());
        assertEquals(5, teNegro.getTiempoInfusion());
    }

    @Test
    public void testTeConTipoVerde() {
        Te teVerde = new Te("Verde");
        assertEquals(3, teVerde.getTiempoInfusion());
    }

    @Test
    public void testMetodoPreparar() throws ExcepcionPreparacion {
        te.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("remojando"));
        assertTrue(salida.contains("té"));
    }

    @Test
    public void testMetodoAgregarCondimentos() throws ExcepcionPreparacion {
        te.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("limón"));
    }

    @Test
    public void testMetodoAgregarExtras() throws ExcepcionPreparacion {
        te.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("miel"));
    }

    @Test
    public void testPrepararRecetaFlujoCompleto() throws ExcepcionPreparacion {
        te.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();

        assertTrue(salida.contains("hirviendo agua"));
        assertTrue(salida.contains("remojando"));
        assertTrue(salida.contains("vertiendo"));
        assertTrue(salida.contains("limón"));
        assertTrue(salida.contains("miel"));
    }

    @Test
    public void testToString() {
        String resultado = te.toString().toLowerCase();
        assertTrue(resultado.contains("te"));
    }

    @Test
    public void testGetTiempoInfusion() {
        assertEquals(3, te.getTiempoInfusion());
    }

    @Test
    public void testGetTipoTe() {
        assertEquals("Verde", te.getTipoTe());
    }
}