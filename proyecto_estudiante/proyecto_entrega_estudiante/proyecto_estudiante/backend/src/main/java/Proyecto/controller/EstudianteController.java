package Proyecto.controller;

import Proyecto.model.Estudiante;
import Proyecto.service.EstudianteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteController {
  private final EstudianteService svc;
  public EstudianteController(EstudianteService svc) { this.svc = svc; }

  @GetMapping
  public List<Estudiante> lista() { return svc.all(); }

  @GetMapping("/{id}")
  public Estudiante get(@PathVariable Long id) { return svc.get(id); }

  @PostMapping
  public Object crear(@RequestBody Map<String,Object> body) {
    try {
      return svc.create(body);
    } catch (IllegalArgumentException ex) {
      return Collections.singletonMap("error", ex.getMessage());
    }
  }

  @PutMapping("/{id}")
  public Object actualizar(@PathVariable Long id, @RequestBody Map<String,Object> body) {
    Estudiante e = svc.update(id, body);
    if (e == null) return Collections.singletonMap("error","No existe");
    return e;
  }

  @DeleteMapping("/{id}")
  public Object borrar(@PathVariable Long id) {
    boolean ok = svc.delete(id);
    if (!ok) return Collections.singletonMap("error","No existe");
    return Collections.singletonMap("msg","eliminado");
  }
}
