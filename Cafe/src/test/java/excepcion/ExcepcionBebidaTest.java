package excepcion;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExcepcionBebidaTest {

    @Test
    public void testExcepcionBebidaConMensaje() {
        ExcepcionBebida excepcion = new ExcepcionBebida("Error de prueba");
        assertEquals("Error de prueba", excepcion.getMessage());
    }

    @Test
    public void testExcepcionBebidaConMensajeYCausa() {
        Throwable causa = new RuntimeException("Causa raíz");
        ExcepcionBebida excepcion =
                new ExcepcionBebida("Error con causa", causa);

        assertEquals("Error con causa", excepcion.getMessage());
        assertEquals(causa, excepcion.getCause());
    }

    @Test
    public void testExcepcionTemperaturaInvalida() {
        ExcepcionTemperaturaInvalida excepcion =
                new ExcepcionTemperaturaInvalida("Temperatura inválida");

        assertTrue(excepcion instanceof ExcepcionBebida);
        assertEquals("Temperatura inválida", excepcion.getMessage());
    }

    @Test
    public void testExcepcionPreparacionConMensaje() {
        ExcepcionPreparacion excepcion =
                new ExcepcionPreparacion("Error en preparación");

        assertTrue(excepcion instanceof ExcepcionBebida);
        assertEquals("Error en preparación", excepcion.getMessage());
    }

    @Test
    public void testExcepcionPreparacionConCausa() {
        Throwable causa = new NullPointerException("Valor nulo");
        ExcepcionPreparacion excepcion =
                new ExcepcionPreparacion("Error con causa", causa);

        assertEquals("Error con causa", excepcion.getMessage());
        assertEquals(causa, excepcion.getCause());
    }

    @Test
    public void testJerarquiaExcepciones() {
        ExcepcionTemperaturaInvalida tempInvalida =
                new ExcepcionTemperaturaInvalida("Test");
        ExcepcionPreparacion preparacion =
                new ExcepcionPreparacion("Test");

        assertTrue(tempInvalida instanceof ExcepcionBebida);
        assertTrue(preparacion instanceof ExcepcionBebida);
        assertTrue(tempInvalida instanceof Exception);
        assertTrue(preparacion instanceof Exception);
    }
}