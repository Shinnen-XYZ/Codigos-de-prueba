package Proyecto.repo;

import Proyecto.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EstudianteRepo {

    private final Map<Long, Estudiante> datos = new HashMap<>();
    private final AtomicLong secuencia = new AtomicLong(1L);

    public List<Estudiante> findAll() {
        return new ArrayList<>(datos.values());
    }

    public Optional<Estudiante> findById(Long id) {
        return Optional.ofNullable(datos.get(id));
    }

    public Optional<Estudiante> findByCorreo(String correo) {
        return datos.values().stream()
                .filter(e -> e.getCorreo() != null && e.getCorreo().equalsIgnoreCase(correo))
                .findFirst();
    }

    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(secuencia.getAndIncrement());
        }
        datos.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    public void deleteById(Long id) {
        datos.remove(id);
    }

    public boolean existsById(Long id) {
        return datos.containsKey(id);
    }
}

