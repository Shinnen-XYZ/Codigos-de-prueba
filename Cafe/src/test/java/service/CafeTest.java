package service;

import excepcion.ExcepcionPreparacion;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class CafeTest {
    private Cafe cafe;
    private ByteArrayOutputStream salidaConsola;
    private PrintStream salidaOriginal;

    @Before
    public void before() {
        cafe = new Cafe("Arábica");
        salidaConsola = new ByteArrayOutputStream();
        salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaConsola));
    }

    @Test
    public void testCafeConstructorPorDefecto() {
        Cafe cafeDefecto = new Cafe();
        assertEquals("Arábica", cafeDefecto.getTipoCafe());
        assertEquals(93, cafeDefecto.getTemperatura());
        assertEquals(4, cafeDefecto.getTiempoPreparacion());
    }

    @Test
    public void testCafeConstructorParametrizado() {
        Cafe cafePersonalizado = new Cafe("Colombiano");
        assertEquals("Colombiano", cafePersonalizado.getTipoCafe());
    }

    @Test
    public void testCafeConTipoNulo() {
        Cafe cafeNulo = new Cafe(null);
        assertEquals("Arábica", cafeNulo.getTipoCafe());
    }

    @Test
    public void testCafeConTipoVacio() {
        Cafe cafeVacio = new Cafe("   ");
        assertEquals("Arábica", cafeVacio.getTipoCafe());
    }

    @Test
    public void testMetodoPreparar() throws ExcepcionPreparacion {
        cafe.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("filtrando"));
        assertTrue(salida.contains("café"));
    }

    @Test
    public void testMetodoAgregarCondimentos() throws ExcepcionPreparacion {
        cafe.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("azúcar"));
        assertTrue(salida.contains("leche"));
    }

    @Test
    public void testMetodoAgregarExtras() throws ExcepcionPreparacion {
        cafe.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("canela"));
    }

    @Test
    public void testPrepararRecetaFlujoCompleto() throws ExcepcionPreparacion {
        cafe.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();

        assertTrue(salida.contains("hirviendo agua"));
        assertTrue(salida.contains("filtrando"));
        assertTrue(salida.contains("vertiendo"));
        assertTrue(salida.contains("agregando"));
        assertTrue(salida.contains("bebida lista"));
    }

    @Test
    public void testToString() {
        String resultado = cafe.toString().toLowerCase();
        assertTrue(resultado.contains("cafe"));
        assertTrue(resultado.contains("arábica"));
    }

    @Test
    public void testGetTemperatura() {
        assertEquals(93, cafe.getTemperatura());
    }

    @Test
    public void testGetTiempoPreparacion() {
        assertEquals(4, cafe.getTiempoPreparacion());
    }

    @Test
    public void testGetTipoCafe() {
        assertEquals("Arábica", cafe.getTipoCafe());
    }
}