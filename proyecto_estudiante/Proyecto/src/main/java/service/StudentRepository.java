package service;

import service.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    // lista para guardar los estudiantes en memoria
    private List<Student> estudiantes;
    private Long idActual;

    // constructor
    public StudentRepository() {
        estudiantes = new ArrayList<Student>();
        idActual = 1L; // empezamos en 1
    }

    // metodo para obtener todos los estudiantes
    public List<Student> obtenerTodos() {
        return estudiantes;
    }

    // metodo para buscar un estudiante por ID
    public Student buscarPorId(Long id) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId().equals(id)) {
                return estudiantes.get(i);
            }
        }
        return null; // si no lo encuentra
    }

    // metodo para buscar por correo
    public Student buscarPorCorreo(String correo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCorreo().equals(correo)) {
                return estudiantes.get(i);
            }
        }
        return null;
    }

    // metodo para guardar un estudiante
    public Student guardar(Student student) {
        // si no tiene ID, es uno nuevo
        if (student.getId() == null) {
            student.setId(idActual);
            idActual++; // incrementamos el ID
            estudiantes.add(student);
        } else {
            // si tiene ID, actualizamos
            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).getId().equals(student.getId())) {
                    estudiantes.set(i, student);
                    break;
                }
            }
        }
        return student;
    }

    // metodo para eliminar un estudiante
    public boolean eliminar(Long id) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId().equals(id)) {
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

    // metodo para verificar si existe un correo
    public boolean existeCorreo(String correo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    // metodo para limpiar todo
    public void limpiar() {
        estudiantes.clear();
        idActual = 1L;
    }
}
