package Proyecto.controller;

import Proyecto.EstudianteService;
import Proyecto.dto.EstudianteRequest;
import Proyecto.model.Estudiante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*") // ← habilita CORS para tu frontend en localhost:63342
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // GET /estudiantes
    @GetMapping
    public List<Estudiante> listar() {
        return service.listarTodos();
    }

    // GET /estudiantes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        try {
            Estudiante e = service.buscarPorId(id);
            return ResponseEntity.ok(e);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    // POST /estudiantes
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EstudianteRequest request) {
        try {
            Estudiante creado = service.crear(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", ex.getMessage()));
        }
    }

    // PUT /estudiantes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCompleto(@PathVariable Long id,
                                                @RequestBody EstudianteRequest request) {
        try {
            Estudiante actualizado = service.actualizarCompleto(id, request);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            String msg = ex.getMessage();
            HttpStatus status = (msg != null && msg.contains("No existe"))
                    ? HttpStatus.NOT_FOUND
                    : HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(status).body(Map.of("error", msg));
        }
    }

    // PATCH /estudiantes/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarParcial(@PathVariable Long id,
                                               @RequestBody Map<String, Object> cambios) {
        try {
            Estudiante actualizado = service.actualizarParcial(id, cambios);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            String msg = ex.getMessage();
            HttpStatus status = (msg != null && msg.contains("No existe"))
                    ? HttpStatus.NOT_FOUND
                    : HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(status).body(Map.of("error", msg));
        }
    }

    // DELETE /estudiantes/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok(Map.of("mensaje", "Estudiante eliminado"));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.getMessage()));
        }
    }
}
