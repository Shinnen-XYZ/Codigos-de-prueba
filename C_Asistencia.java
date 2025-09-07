package service;

import java.util.*;

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
        this.estudiantes = estudiantes;
    }

    public boolean removeEstudiante(C_Estudiante estudiante) {
        return estudiantes.remove(estudiante);
    }

    public C_Estudiante buscarPorCarnet(int carnet) {
        for(C_Estudiante est : estudiantes) {
            if(est.getCarnet() == carnet) {
                return est;
            }
        }
        return null;
    }

    public int cantidadEstudiantes() {
        return estudiantes.size();
    }

    public boolean estaVacia() {
        return estudiantes.isEmpty();
    }

    public String toString(){
        return "C_Asistencia{estudiantes=" + estudiantes + "}";
    }
}
