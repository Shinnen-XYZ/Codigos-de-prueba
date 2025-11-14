package Proyecto;

import Proyecto.dto.EstudianteRequest;
import Proyecto.model.Estudiante;
import Proyecto.repo.EstudianteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EstudianteService {

    private final EstudianteRepo repo;

    public EstudianteService(EstudianteRepo repo) {
        this.repo = repo;
    }

    // Listar todos
    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    // Buscar por id
    public Estudiante buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe estudiante con ID " + id));
    }

    // Crear estudiante nuevo
    public Estudiante crear(EstudianteRequest request) {

        // Validar idioma
        if (!esIdiomaValido(request.getIdioma())) {
            throw new IllegalArgumentException("El idioma debe ser español, inglés o francés");
        }

        // Validar que el correo no esté repetido
        if (repo.findByCorreo(request.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un estudiante con ese correo");
        }

        Estudiante e = new Estudiante();
        e.setNombre(request.getNombre());
        e.setCorreo(request.getCorreo());
        e.setNumeroTelefono(request.getNumeroTelefono());
        e.setIdioma(normalizarIdioma(request.getIdioma()));

        return repo.save(e);
    }

    // Actualizar todos los campos (PUT)
    public Estudiante actualizarCompleto(Long id, EstudianteRequest request) {

        Estudiante existente = buscarPorId(id);

        if (!esIdiomaValido(request.getIdioma())) {
            throw new IllegalArgumentException("El idioma debe ser español, inglés o francés");
        }

        // Verificar que el correo no choque con otro estudiante
        repo.findByCorreo(request.getCorreo()).ifPresent(e -> {
            if (!e.getId().equals(id)) {
                throw new IllegalArgumentException("Ese correo ya está registrado");
            }
        });

        existente.setNombre(request.getNombre());
        existente.setCorreo(request.getCorreo());
        existente.setNumeroTelefono(request.getNumeroTelefono());
        existente.setIdioma(normalizarIdioma(request.getIdioma()));

        return repo.save(existente);
    }

    // Actualizar solo algunos campos (PATCH)
    public Estudiante actualizarParcial(Long id, Map<String, Object> cambios) {

        Estudiante existente = buscarPorId(id);

        if (cambios.containsKey("nombre")) {
            Object valor = cambios.get("nombre");
            if (valor != null) {
                existente.setNombre(valor.toString());
            }
        }

        if (cambios.containsKey("correo")) {
            Object valor = cambios.get("correo");
            if (valor != null) {
                String correo = valor.toString();
                repo.findByCorreo(correo).ifPresent(e -> {
                    if (!e.getId().equals(id)) {
                        throw new IllegalArgumentException("Ese correo ya está registrado");
                    }
                });
                existente.setCorreo(correo);
            }
        }

        if (cambios.containsKey("numero_telefono")) {
            Object valor = cambios.get("numero_telefono");
            if (valor != null) {
                String tel = valor.toString();
                if (!tel.matches("\\d{8}")) {
                    throw new IllegalArgumentException("El teléfono debe tener 8 dígitos");
                }
                existente.setNumeroTelefono(tel);
            }
        }

        if (cambios.containsKey("idioma")) {
            Object valor = cambios.get("idioma");
            if (valor != null) {
                String idioma = valor.toString();
                if (!esIdiomaValido(idioma)) {
                    throw new IllegalArgumentException("Idioma inválido");
                }
                existente.setIdioma(normalizarIdioma(idioma));
            }
        }

        return repo.save(existente);
    }

    // Eliminar
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe estudiante con ID " + id);
        }
        repo.deleteById(id);
    }

    // Validar idioma
    private boolean esIdiomaValido(String idioma) {
        if (idioma == null) return false;
        String i = idioma.toLowerCase();
        return i.contains("espa") || i.contains("ingl") || i.contains("fran");
    }

    // Dejar el idioma con tilde y bien escrito
    private String normalizarIdioma(String idioma) {
        String i = idioma.toLowerCase();
        if (i.contains("espa")) return "español";
        if (i.contains("ingl")) return "inglés";
        if (i.contains("fran")) return "francés";
        return idioma;
    }
}
