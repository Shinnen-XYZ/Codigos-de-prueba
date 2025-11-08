package service;

import excepcion.ExcepcionPreparacion;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class LimonadaTest {
    private Limonada limonada;
    private ByteArrayOutputStream salidaConsola;

    @Before
    public void before() {
        limonada = new Limonada("Media", 5);
        salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));
    }

    @Test
    public void testLimonadaConstructorPorDefecto() {
        Limonada limonadaDefecto = new Limonada();
        assertEquals("Media", limonadaDefecto.getNivelAzucar());
        assertEquals(0, limonadaDefecto.getTemperatura());
        assertEquals(2, limonadaDefecto.getTiempoPreparacion());
        assertEquals(5, limonadaDefecto.getCantidadHielo());
    }

    @Test
    public void testLimonadaConNivelAzucarPersonalizado() {
        Limonada limonadaPersonalizada = new Limonada("Alta", 8);
        assertEquals("Alta", limonadaPersonalizada.getNivelAzucar());
        assertEquals(8, limonadaPersonalizada.getCantidadHielo());
    }

    @Test
    public void testLimonadaConHieloNegativo() {
        Limonada hieloNegativo = new Limonada("Baja", -3);
        assertEquals(5, hieloNegativo.getCantidadHielo());
    }

    @Test
    public void testMetodoHervirAguaSobrescrito() throws ExcepcionPreparacion {
        limonada.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("agua fría"));
        assertTrue(salida.contains("sin hervir"));
    }

    @Test
    public void testMetodoPreparar() throws ExcepcionPreparacion {
        limonada.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("exprimiendo"));
        assertTrue(salida.contains("limones"));
    }

    @Test
    public void testMetodoAgregarCondimentos() throws ExcepcionPreparacion {
        limonada.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("azúcar"));
    }

    @Test
    public void testMetodoAgregarExtras() throws ExcepcionPreparacion {
        limonada.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();
        assertTrue(salida.contains("cubos de hielo"));
    }

    @Test
    public void testPrepararRecetaFlujoCompleto() throws ExcepcionPreparacion {
        limonada.prepararReceta();
        String salida = salidaConsola.toString().toLowerCase();

        assertTrue(salida.contains("agua fría"));
        assertTrue(salida.contains("exprimiendo"));
        assertTrue(salida.contains("vertiendo"));
        assertTrue(salida.contains("azúcar"));
        assertTrue(salida.contains("hielo"));
    }

    @Test
    public void testToString() {
        String resultado = limonada.toString().toLowerCase();
        assertTrue(resultado.contains("limonada"));
    }

    @Test
    public void testGetCantidadHielo() {
        assertEquals(5, limonada.getCantidadHielo());
    }

    @Test
    public void testGetNivelAzucar() {
        assertEquals("Media", limonada.getNivelAzucar());
    }
}