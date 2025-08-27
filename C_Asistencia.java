package service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@Getter
@Setter
@ToString
public class C_Asistencia {
    private List<C_Estudiante> estudiantes;

    public C_Asistencia() {
        estudiantes = new LinkedList<>();
    }

    public void addEstudiante(C_Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}
