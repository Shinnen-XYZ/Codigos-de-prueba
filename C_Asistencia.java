package service;

import java.util.ArrayList;

public class C_Asistencia {
    ArrayList<C_Estudiante> estudiantes;

    public C_Asistencia() {
        estudiantes = new ArrayList<C_Estudiante>();
    }

    public void addEstudiante(C_Estudiante estudiante) {
        if (estudiante == null) {
            throw new MyException("No se puede agregar un estudiante nulo");
        }
        estudiantes.add(estudiante);
    }

    public ArrayList<C_Estudiante> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public String toString() {
        return "C_Asistencia{estudiantes=" + estudiantes + "}";
    }

    // Clase interna MyException
    public static class MyException extends RuntimeException {
        public MyException(String mensaje) {
            super(mensaje);
        }

        @Override
        public String toString() {
            return "MyException: " + getMessage();
        }
    }
}
