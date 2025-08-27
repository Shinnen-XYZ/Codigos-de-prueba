package service;

import lombok.ToString;
import lombok.Getter;
import java.util.*;

@ToString
@Getter
public class C_Asistencia {
    private List<C_Estudiante> estudiantes;

    public C_Asistencia() {
        estudiantes = new LinkedList<>();
    }
    public void addEstudiante(C_Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
}
