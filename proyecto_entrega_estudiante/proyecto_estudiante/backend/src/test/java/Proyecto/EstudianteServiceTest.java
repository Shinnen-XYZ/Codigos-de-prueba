package Proyecto;

import Proyecto.Factory.EstudianteFactory;
import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class EstudianteServiceTest {

    private EstudianteService service;

    @Before
    public void setUp() {
        EstudianteRepo repo = new EstudianteRepo();
        EstudianteFactory factory = new EstudianteFactory();
        service = new EstudianteService(repo, factory);
    }

    @Test
    public void crearEstudianteOk() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Juan Pérez");
        data.put("correo", "juan@example.com");
        data.put("telefono", "12345678");
        data.put("idioma", "espanol");

        Estudiante e = service.create(data);

        assertNotNull(e.getId());
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals("juan@example.com", e.getCorreo());
        assertEquals("12345678", e.getTelefono());
        // Se normaliza usando Strategy
        assertEquals("español", e.getIdioma());
    }

    @Test(expected = IllegalArgumentException.class)
    public void noPermiteCorreoDuplicado() {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("nombre", "A");
        data1.put("correo", "dup@example.com");
        data1.put("telefono", "11111111");
        data1.put("idioma", "español");
        service.create(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("nombre", "B");
        data2.put("correo", "dup@example.com");
        data2.put("telefono", "22222222");
        data2.put("idioma", "inglés");

        // Debe lanzar IllegalArgumentException
        service.create(data2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void telefonoDebeTener8Digitos() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Carlos");
        data.put("correo", "carlos@example.com");
        data.put("telefono", "1234"); // inválido
        data.put("idioma", "español");

        service.create(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void idiomaInvalidoLanzaExcepcion() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Ana");
        data.put("correo", "ana@example.com");
        data.put("telefono", "87654321");
        data.put("idioma", "alemán"); // no soportado

        service.create(data);
    }
}
