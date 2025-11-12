package Proyecto.factory;

import Proyecto.model.Estudiante;
import java.util.Map;

public class EstudianteFactory {
  public static Estudiante fromMap(Map<String,Object> m) {
    Estudiante e = new Estudiante();
    e.setNombre((String)m.get("nombre"));
    e.setCorreo((String)m.get("correo"));
    e.setTelefono((String)m.get("telefono"));
    e.setIdioma((String)m.get("idioma"));
    return e;
  }
}
