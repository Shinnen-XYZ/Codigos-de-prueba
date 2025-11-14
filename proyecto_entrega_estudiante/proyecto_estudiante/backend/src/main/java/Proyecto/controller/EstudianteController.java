package Proyecto.controller;

import Proyecto.EstudianteService;
import Proyecto.dto.EstudianteRequest;
import Proyecto.model.Estudiante;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    // Listar todos los estudiantes
    @GetMapping
    public List<Estudiante> listar() {
        return service.listarTodos();
    }

    // Obtener estudiante por id
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

    // Crear estudiante (POST)
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody EstudianteRequest request,
                                   BindingResult bindingResult) {

        // Validaciones de anotaciones
        if (bindingResult.hasErrors()) {
            List<String> mensajes = new ArrayList<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                mensajes.add(fe.getDefaultMessage());
            }
            String errores = String.join(", ", mensajes);
            return ResponseEntity.badRequest().body(Map.of("error", errores));
        }

        try {
            Estudiante creado = service.crear(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
        }
    }

    // Actualizar completo (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCompleto(
            @PathVariable Long id,
            @Valid @RequestBody EstudianteRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> mensajes = new ArrayList<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                mensajes.add(fe.getDefaultMessage());
            }
            String errores = String.join(", ", mensajes);
            return ResponseEntity.badRequest().body(Map.of("error", errores));
        }

        try {
            Estudiante actualizado = service.actualizarCompleto(id, request);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            HttpStatus status;
            if (ex.getMessage() != null && ex.getMessage().contains("No existe")) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.BAD_REQUEST;
            }
            return ResponseEntity.status(status).body(Map.of("error", ex.getMessage()));
        }
    }

    // Actualizar campos específicos (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarParcial(
            @PathVariable Long id,
            @RequestBody Map<String, Object> cambios) {

        try {
            Estudiante actualizado = service.actualizarParcial(id, cambios);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException ex) {
            HttpStatus status;
            if (ex.getMessage() != null && ex.getMessage().contains("No existe")) {
                status = HttpStatus.NOT_FOUND;
            } else {
                status = HttpStatus.BAD_REQUEST;
            }
            return ResponseEntity.status(status).body(Map.of("error", ex.getMessage()));
        }
    }

    // Eliminar estudiante
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
