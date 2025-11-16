package Proyecto.Factory;

import Proyecto.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EstudianteFactory {

    // Crea un Estudiante a partir de un Map (lo que viene del JSON del frontend)
    public Estudiante fromMap(Map<String, Object> data) {
        Estudiante e = new Estudiante();

        Object n = data.get("nombre");
        Object c = data.get("correo");
        Object t = data.get("telefono");
        Object i = data.get("idioma");

        e.setNombre(n != null ? n.toString() : null);
        e.setCorreo(c != null ? c.toString() : null);
        e.setTelefono(t != null ? t.toString() : null);
        e.setIdioma(i != null ? i.toString() : null);

        return e;
    }
}
