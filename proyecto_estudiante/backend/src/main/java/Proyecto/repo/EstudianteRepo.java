package Proyecto.repo;

import Proyecto.model.Estudiante;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EstudianteRepo {
  private Map<Long, Estudiante> datos = new HashMap<>();
  private long seq = 1;

  public List<Estudiante> findAll() { return new ArrayList<>(datos.values()); }
  public Optional<Estudiante> findById(Long id) { return Optional.ofNullable(datos.get(id)); }
  public Optional<Estudiante> findByCorreo(String correo) {
    return datos.values().stream().filter(e->e.getCorreo()!=null && e.getCorreo().equalsIgnoreCase(correo)).findFirst();
  }
  public Estudiante save(Estudiante e) {
    if (e.getId() == null) e.setId(seq++);
    datos.put(e.getId(), e);
    return e;
  }
  public void delete(Long id) { datos.remove(id); }
  public boolean existsById(Long id) { return datos.containsKey(id); }
}
