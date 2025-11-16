package Proyecto;

import Proyecto.Factory.EstudianteFactory;
import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import Proyecto.strategy.IdiomaStrategy;
import Proyecto.strategy.IdiomaStrategyFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {

    private final EstudianteRepo repo;
    private final EstudianteFactory factory;
    private final IdiomaStrategyFactory idiomaFactory;

    public EstudianteService(EstudianteRepo repo, EstudianteFactory factory) {
        this.repo = repo;
        this.factory = factory;
        this.idiomaFactory = new IdiomaStrategyFactory();
    }

    public List<Estudiante> all() {
        return repo.findAll();
    }

    public Estudiante get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe estudiante con ID " + id));
    }

    public Estudiante create(Map<String, Object> data) {
        Estudiante e = factory.fromMap(data);
        validar(e, true, null);
        return repo.save(e);
    }

    public Estudiante update(Long id, Map<String, Object> data) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID " + id);
        }
        Estudiante e = factory.fromMap(data);
        e.setId(id);
        validar(e, false, id);
        return repo.save(e);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID " + id);
        }
        repo.deleteById(id);
    }

    // Validaciones de negocio
    private void validar(Estudiante e, boolean esNuevo, Long idActual) {

        if (e.getNombre() == null || e.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        String correo = e.getCorreo();
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        if (!correo.contains("@") || !correo.contains(".")) {
            throw new IllegalArgumentException("El correo no es válido");
        }

        repo.findByCorreo(correo).ifPresent(otro -> {
            if (esNuevo || !otro.getId().equals(idActual)) {
                throw new IllegalArgumentException("Ya existe un estudiante con ese correo");
            }
        });

        String tel = e.getTelefono();
        if (tel == null || !tel.matches("\\d{8}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 8 dígitos");
        }

        String idiomaOriginal = e.getIdioma();
        if (idiomaOriginal == null || idiomaOriginal.trim().isEmpty()) {
            throw new IllegalArgumentException("El idioma es obligatorio");
        }

        IdiomaStrategy estrategia = idiomaFactory.obtenerEstrategia(idiomaOriginal);
        estrategia.aplicar(e); // normaliza el idioma a "español", "inglés" o "francés"
    }
}
