package Proyecto;

import Proyecto.dto.EstudianteRequest;
import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import Proyecto.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstudianteServiceTest {

    private EstudianteRepo repo;
    private EstudianteService service;

    @BeforeEach
    void before() {
        // Usamos el repositorio real en memoria, sin mocks
        repo = new EstudianteRepo();
        service = new EstudianteService(repo);
    }

    @Test
    void crear_estudiante_ok() {
        EstudianteRequest req = new EstudianteRequest();
        req.setNombre("Juan Pérez");
        req.setCorreo("juan@example.com");
        req.setNumeroTelefono("1234567890");
        req.setIdioma("español");

        Estudiante creado = service.crear(req);

        assertNotNull(creado.getId());
        assertEquals("Juan Pérez", creado.getNombre());
        assertEquals("juan@example.com", creado.getCorreo());
        assertEquals("1234567890", creado.getNumeroTelefono());
        assertEquals("español", creado.getIdioma());

        List<Estudiante> lista = service.listarTodos();
        assertEquals(1, lista.size());
    }

    @Test
    void crear_correo_duplicado_lanza_excepcion() {
        EstudianteRequest req1 = new EstudianteRequest();
        req1.setNombre("Ana");
        req1.setCorreo("ana@example.com");
        req1.setNumeroTelefono("1234567890");
        req1.setIdioma("inglés");

        EstudianteRequest req2 = new EstudianteRequest();
        req2.setNombre("Otra Ana");
        req2.setCorreo("ana@example.com"); // mismo correo
        req2.setNumeroTelefono("0987654321");
        req2.setIdioma("español");

        // Primer create: ok
        service.crear(req1);

        // Segundo create con mismo correo: debe fallar
        assertThrows(IllegalArgumentException.class,
                () -> service.crear(req2));
    }

    @Test
    void eliminar_no_existente_lanza_excepcion() {
        // No hay ningún estudiante en el repo
        assertThrows(IllegalArgumentException.class,
                () -> service.eliminar(10L));
    }
}

