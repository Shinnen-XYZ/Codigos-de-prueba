package Proyecto;

import Proyecto.Factory.EstudianteFactory;
import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EstudianteServiceTest {

    private EstudianteService service;

    @BeforeEach
    void setUp() {
        EstudianteRepo repo = new EstudianteRepo();
        EstudianteFactory factory = new EstudianteFactory();
        service = new EstudianteService(repo, factory);
    }

    @Test
    void crearEstudianteOk() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Juan Pérez");
        data.put("correo", "juan@gmail.com");
        data.put("telefono", "12345678");
        data.put("idioma", "espanol");

        Estudiante e = service.create(data);

        assertNotNull(e.getId());
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals("juan@gmail.com", e.getCorreo());
        assertEquals("12345678", e.getTelefono());
        assertEquals("español", e.getIdioma());
    }

    @Test
    void noPermiteCorreoDuplicado() {
        Map<String, Object> data1 = new HashMap<>();
        data1.put("nombre", "A");
        data1.put("correo", "dup@gmail.com");
        data1.put("telefono", "11111111");
        data1.put("idioma", "español");
        service.create(data1);

        Map<String, Object> data2 = new HashMap<>();
        data2.put("nombre", "B");
        data2.put("correo", "dup@gmail.com");
        data2.put("telefono", "22222222");
        data2.put("idioma", "inglés");

        assertThrows(IllegalArgumentException.class, () -> service.create(data2));
    }

    @Test
    void telefonoDebeTener8Digitos() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Carlos");
        data.put("correo", "carlos@gmail.com");
        data.put("telefono", "1234");
        data.put("idioma", "español");

        assertThrows(IllegalArgumentException.class, () -> service.create(data));
    }

    @Test
    void idiomaInvalidoLanzaExcepcion() {
        Map<String, Object> data = new HashMap<>();
        data.put("nombre", "Ana");
        data.put("correo", "ana@gmail.com");
        data.put("telefono", "87654321");
        data.put("idioma", "alemán");

        assertThrows(IllegalArgumentException.class, () -> service.create(data));
    }
}
