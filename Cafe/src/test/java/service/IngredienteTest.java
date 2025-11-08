package service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredienteTest {
    private Ingrediente<Integer> ingredienteEntero;
    private Ingrediente<Double> ingredienteDecimal;
    private Ingrediente<String> ingredienteTexto;

    @Before
    public void setUp() {
        ingredienteEntero = new Ingrediente<>("Azúcar", 2, "cucharadas");
        ingredienteDecimal = new Ingrediente<>("Leche", 250.5, "ml");
        ingredienteTexto = new Ingrediente<>("Canela", "Una pizca", "");
    }

    @Test
    public void testIngredienteConEntero() {
        assertEquals("Azúcar", ingredienteEntero.getNombre());
        assertEquals(Integer.valueOf(2), ingredienteEntero.getCantidad());
        assertEquals("cucharadas", ingredienteEntero.getUnidad());
    }

    @Test
    public void testIngredienteConDecimal() {
        assertEquals("Leche", ingredienteDecimal.getNombre());
        assertEquals(Double.valueOf(250.5), ingredienteDecimal.getCantidad());
        assertEquals("ml", ingredienteDecimal.getUnidad());
    }

    @Test
    public void testIngredienteConTexto() {
        assertEquals("Canela", ingredienteTexto.getNombre());
        assertEquals("Una pizca", ingredienteTexto.getCantidad());
        assertEquals("", ingredienteTexto.getUnidad());
    }

    @Test
    public void testToString() {
        String resultado = ingredienteEntero.toString();
        assertTrue(resultado.contains("Azúcar"));
        assertTrue(resultado.contains("2"));
        assertTrue(resultado.contains("cucharadas"));
    }

    @Test
    public void testGenericidadConDiferentesTipos() {
        Ingrediente<Boolean> ingredienteBooleano =
                new Ingrediente<>("Con hielo", true, "");
        assertEquals(Boolean.TRUE, ingredienteBooleano.getCantidad());
    }
}