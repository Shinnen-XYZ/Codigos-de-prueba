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

    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    public Estudiante buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el estudiante con id " + id));
    }

    public Estudiante crear(EstudianteRequest request) {

        // Validar idioma
        if (!esIdiomaValido(request.getIdioma())) {
            throw new IllegalArgumentException("El idioma debe ser inglés, español o francés");
        }

        // Validar correo único
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

    public Estudiante actualizarCompleto(Long id, EstudianteRequest request) {

        Estudiante existente = buscarPorId(id);

        if (!esIdiomaValido(request.getIdioma())) {
            throw new IllegalArgumentException("El idioma debe ser inglés, español o francés");
        }

        repo.findByCorreo(request.getCorreo()).ifPresent(e -> {
            if (!e.getId().equals(id)) {
                throw new IllegalArgumentException("Ya existe otro estudiante con ese correo");
            }
        });

        existente.setNombre(request.getNombre());
        existente.setCorreo(request.getCorreo());
        existente.setNumeroTelefono(request.getNumeroTelefono());
        existente.setIdioma(normalizarIdioma(request.getIdioma()));

        return repo.save(existente);
    }

    public Estudiante actualizarParcial(Long id, Map<String, Object> cambios) {

        Estudiante existente = buscarPorId(id);

        if (cambios.containsKey("nombre")) {
            Object v = cambios.get("nombre");
            if (v != null) {
                String nombre = v.toString();
                if (nombre.isBlank() || nombre.length() > 255) {
                    throw new IllegalArgumentException("Nombre inválido");
                }
                existente.setNombre(nombre);
            }
        }

        if (cambios.containsKey("correo")) {
            Object v = cambios.get("correo");
            if (v != null) {
                String correo = v.toString();
                if (!correo.contains("@") || !correo.contains(".")) {
                    throw new IllegalArgumentException("Correo inválido");
                }
                repo.findByCorreo(correo).ifPresent(e -> {
                    if (!e.getId().equals(id)) {
                        throw new IllegalArgumentException("Ya existe otro estudiante con ese correo");
                    }
                });
                existente.setCorreo(correo);
            }
        }

        if (cambios.containsKey("numero_telefono")) {
            Object v = cambios.get("numero_telefono");
            if (v != null) {
                String tel = v.toString();
                if (!tel.matches("\\d{8}")) {
                    throw new IllegalArgumentException("El teléfono debe tener 10 dígitos");
                }
                existente.setNumeroTelefono(tel);
            }
        }

        if (cambios.containsKey("idioma")) {
            Object v = cambios.get("idioma");
            if (v != null) {
                String idioma = v.toString();
                if (!esIdiomaValido(idioma)) {
                    throw new IllegalArgumentException("El idioma debe ser inglés, español o francés");
                }
                existente.setIdioma(normalizarIdioma(idioma));
            }
        }

        return repo.save(existente);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("No existe el estudiante con id " + id);
        }
        repo.deleteById(id);
    }

    private boolean esIdiomaValido(String idioma) {
        if (idioma == null) return false;
        String i = idioma.toLowerCase();
        return i.equals("ingles") || i.equals("inglés") ||
                i.equals("espanol") || i.equals("español") ||
                i.equals("frances") || i.equals("francés");
    }

    private String normalizarIdioma(String idioma) {
        String i = idioma.toLowerCase();
        if (i.contains("ingl")) return "inglés";
        if (i.contains("espa")) return "español";
        if (i.contains("fran")) return "francés";
        return idioma;
    }
}
