package service;
import lombok.ToString;

import java.util.*;
public class C_Asistencia {
    @lombok.ToString

    private List<C_Estudiante> estudiantes;

    public C_Asistencia() {
        estudiantes = new LinkedList<>();
    }
    public void addEstudiante (C_Estudiante estudiante){
        estudiantes.add(estudiante);
    }
}
