package service;

import service.Student;
import service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // metodo para obtener todos los estudiantes
    public List<Student> obtenerTodos() {
        return repository.obtenerTodos();
    }

    // metodo para obtener un estudiante por ID
    public Student obtenerPorId(Long id) throws Exception {
        Student student = repository.buscarPorId(id);
        if (student == null) {
            throw new Exception("Estudiante con ID " + id + " no encontrado");
        }
        return student;
    }

    // metodo para crear un estudiante nuevo
    public Student crear(Student student) throws Exception {
        // validar nombre
        if (student.getNombre() == null || student.getNombre().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (student.getNombre().length() > 255) {
            throw new Exception("El nombre no puede tener mas de 255 caracteres");
        }

        // validar correo
        if (student.getCorreo() == null || student.getCorreo().isEmpty()) {
            throw new Exception("El correo es obligatorio");
        }
        if (!student.getCorreo().contains("@")) {
            throw new Exception("El correo no es valido");
        }
        if (repository.existeCorreo(student.getCorreo())) {
            throw new Exception("El correo ya esta registrado");
        }

        // validar telefono
        if (student.getNumeroTelefono() == null || student.getNumeroTelefono().isEmpty()) {
            throw new Exception("El numero de telefono es obligatorio");
        }
        if (student.getNumeroTelefono().length() != 10) {
            throw new Exception("El telefono debe tener 10 digitos");
        }
        // verificar que solo sean numeros
        for (int i = 0; i < student.getNumeroTelefono().length(); i++) {
            if (!Character.isDigit(student.getNumeroTelefono().charAt(i))) {
                throw new Exception("El telefono solo debe contener numeros");
            }
        }

        // validar idioma
        if (student.getIdioma() == null || student.getIdioma().isEmpty()) {
            throw new Exception("El idioma es obligatorio");
        }
        if (!student.getIdioma().equals("inglés") &&
                !student.getIdioma().equals("español") &&
                !student.getIdioma().equals("francés")) {
            throw new Exception("El idioma debe ser: inglés, español o francés");
        }

        return repository.guardar(student);
    }

    // metodo para actualizar un estudiante completo
    public Student actualizar(Long id, Student student) throws Exception {
        Student existente = repository.buscarPorId(id);
        if (existente == null) {
            throw new Exception("Estudiante con ID " + id + " no encontrado");
        }

        // validar el correo si cambio
        if (!existente.getCorreo().equals(student.getCorreo())) {
            if (repository.existeCorreo(student.getCorreo())) {
                throw new Exception("El correo ya esta registrado");
            }
        }

        // validaciones basicas
        if (student.getNombre() == null || student.getNombre().isEmpty()) {
            throw new Exception("El nombre es obligatorio");
        }
        if (student.getCorreo() == null || !student.getCorreo().contains("@")) {
            throw new Exception("El correo no es valido");
        }
        if (student.getNumeroTelefono() == null || student.getNumeroTelefono().length() != 10) {
            throw new Exception("El telefono debe tener 10 digitos");
        }

        student.setId(id);
        return repository.guardar(student);
    }

    // metodo para actualizar parcialmente
    public Student actualizarParcial(Long id, Student cambios) throws Exception {
        Student existente = repository.buscarPorId(id);
        if (existente == null) {
            throw new Exception("Estudiante con ID " + id + " no encontrado");
        }

        // solo actualizar lo que venga
        if (cambios.getNombre() != null) {
            existente.setNombre(cambios.getNombre());
        }
        if (cambios.getCorreo() != null) {
            if (!existente.getCorreo().equals(cambios.getCorreo())) {
                if (repository.existeCorreo(cambios.getCorreo())) {
                    throw new Exception("El correo ya esta registrado");
                }
            }
            existente.setCorreo(cambios.getCorreo());
        }
        if (cambios.getNumeroTelefono() != null) {
            existente.setNumeroTelefono(cambios.getNumeroTelefono());
        }
        if (cambios.getIdioma() != null) {
            existente.setIdioma(cambios.getIdioma());
        }

        return repository.guardar(existente);
    }

    // metodo para eliminar
    public void eliminar(Long id) throws Exception {
        Student existente = repository.buscarPorId(id);
        if (existente == null) {
            throw new Exception("Estudiante con ID " + id + " no encontrado");
        }
        repository.eliminar(id);
    }
}