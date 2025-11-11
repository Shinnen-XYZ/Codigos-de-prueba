package Proyecto.service;

import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import Proyecto.factory.EstudianteFactory;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EstudianteService {
  private final EstudianteRepo repo;
  public EstudianteService(EstudianteRepo repo) { this.repo = repo; }

  public List<Estudiante> all() { return repo.findAll(); }
  public Estudiante get(Long id) { return repo.findById(id).orElse(null); }

  public Estudiante create(Map<String,Object> data) {
    // validations simples
    if (data.get("nombre") == null || ((String)data.get("nombre")).trim().isEmpty()) {
      throw new IllegalArgumentException("Nombre obligatorio");
    }
    if (data.get("correo") == null) throw new IllegalArgumentException("Correo obligatorio");
    String correo = (String)data.get("correo");
    if (repo.findByCorreo(correo).isPresent()) throw new IllegalArgumentException("Correo ya existe");
    String tel = (String)data.get("telefono");
    if (tel == null || !tel.matches("\\d{10}")) throw new IllegalArgumentException("Teléfono debe tener 10 dígitos");
    String idioma = (String)data.get("idioma");
    if (idioma==null || !(idioma.equalsIgnoreCase("español")||idioma.equalsIgnoreCase("inglés")||idioma.equalsIgnoreCase("francés")))
      throw new IllegalArgumentException("Idioma inválido");
    Estudiante e = EstudianteFactory.fromMap(data);
    return repo.save(e);
  }

  public Estudiante update(Long id, Map<String,Object> data) {
    if (!repo.existsById(id)) return null;
    Estudiante e = EstudianteFactory.fromMap(data);
    e.setId(id);
    return repo.save(e);
  }

  public boolean delete(Long id) {
    if (!repo.existsById(id)) return false;
    repo.delete(id);
    return true;
  }
}
