package service;

import excepcion.ExcepcionPreparacion;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class ChocolateCalienteTest {
    private ChocolateCaliente chocolate;
    private ByteArrayOutputStream salidaConsola;

    @Before
    public void before() {
        chocolate = new ChocolateCaliente("Semiamargo", true);
        salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));
    }

    @Test
    public void testChocolateConstructorPorDefecto() {
        ChocolateCaliente chocolateDefecto = new ChocolateCaliente();
        assertEquals("Semiamargo", chocolateDefecto.getTipoChocolate());
        assertEquals(85, chocolateDefecto.getTemperatura());
        assertEquals(5, chocolateDefecto.getTiempoPreparacion());
        assertTrue(chocolateDefecto.isConMalvaviscos());
    }

    @Test
    public void testChocolateConMalvaviscos() {
        ChocolateCaliente conMalvaviscos = new ChocolateCaliente("Dulce", true);
        assertTrue(conMalvaviscos.isConMalvaviscos());
    }

    @Test
    public void testChocolateSinMalvaviscos() {
        ChocolateCaliente sinMalvaviscos = new ChocolateCaliente("Amargo", false);
        assertFalse(sinMalvaviscos.isConMalvaviscos());
    }

    @Test
    public void testMetodoPreparar() throws ExcepcionPreparacion {
        chocolate.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("mezclando"));
        assertTrue(salida.contains("cacao"));
    }

    @Test
    public void testMetodoAgregarCondimentos() throws ExcepcionPreparacion {
        chocolate.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("crema"));
    }

    @Test
    public void testMetodoAgregarExtrasConMalvaviscos() throws ExcepcionPreparacion {
        chocolate.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("malvaviscos"));
    }

    @Test
    public void testMetodoAgregarExtrasSinMalvaviscos() throws ExcepcionPreparacion {
        ChocolateCaliente sinMalvaviscos = new ChocolateCaliente("Dulce", false);
        sinMalvaviscos.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertFalse(salida.contains("malvaviscos"));
    }

    @Test
    public void testPrepararRecetaFlujoCompleto() throws ExcepcionPreparacion {
        chocolate.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();

        assertTrue(salida.contains("hirviendo agua"));
        assertTrue(salida.contains("mezclando"));
        assertTrue(salida.contains("vertiendo"));
        assertTrue(salida.contains("crema"));
    }

    @Test
    public void testToString() {
        String resultado = chocolate.toString().toLowerCase();
        assertTrue(resultado.contains("chocolatecaliente"));
    }

    @Test
    public void testIsConMalvaviscos() {
        assertTrue(chocolate.isConMalvaviscos());
    }

    @Test
    public void testGetTipoChocolate() {
        assertEquals("Semiamargo", chocolate.getTipoChocolate());
    }
}