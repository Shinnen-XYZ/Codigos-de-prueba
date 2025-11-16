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

    // Listar todos
    public List<Estudiante> all() {
        return repo.findAll();
    }

    // Buscar por id
    public Estudiante get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe estudiante con ID " + id));
    }

    // Crear estudiante nuevo
    public Estudiante create(Map<String, Object> data) {
        Estudiante e = factory.fromMap(data);
        validar(e, true, null);
        return repo.save(e);
    }

    // Actualizar todos los campos (PUT)
    public Estudiante update(Long id, Map<String, Object> data) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID " + id);
        }

        Estudiante e = factory.fromMap(data);
        e.setId(id);
        validar(e, false, id);
        return repo.save(e);
    }

    // Eliminar
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID " + id);
        }
        repo.deleteById(id);
    }

    // Validaciones de negocio
    private void validar(Estudiante e, boolean esNuevo, Long idActual) {

        // Nombre
        if (e.getNombre() == null || e.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        // Correo
        String correo = e.getCorreo();
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        if (!correo.contains("@") || !correo.contains(".")) {
            throw new IllegalArgumentException("El correo no es válido");
        }

        // Correo único
        repo.findByCorreo(correo).ifPresent(otro -> {
            if (esNuevo || !otro.getId().equals(idActual)) {
                throw new IllegalArgumentException("Ya existe un estudiante con ese correo");
            }
        });

        // Teléfono: exactamente 8 dígitos
        String tel = e.getTelefono();
        if (tel == null || !tel.matches("\\d{8}")) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 8 dígitos");
        }

        // Idioma: se valida y normaliza usando Strategy
        String idiomaOriginal = e.getIdioma();
        if (idiomaOriginal == null || idiomaOriginal.trim().isEmpty()) {
            throw new IllegalArgumentException("El idioma es obligatorio");
        }

        IdiomaStrategy estrategia = idiomaFactory.obtenerEstrategia(idiomaOriginal);
        estrategia.aplicar(e); // aquí deja el idioma normalizado
    }
}
