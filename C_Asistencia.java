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
        estudiantes = new LinkedList();
    }

    public void addEstudiante(C_Estudiante e) throws RuntimeException{
        if( null == e )
            throw new RuntimeException("No se permiten estudiantes vacios");
        estudiantes.add(e);
    }

    public List<C_Estudiante> getEstudiantes() {
        return new LinkedList(estudiantes);
    }

    public void setEstudiantes(List<C_Estudiante> estudiantes) {
        for (C_Estudiante cEstudiante : this.estudiantes = estudiantes) {
        }
    }


}