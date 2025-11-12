package service;

// Clase para representar un estudiante
public class Student {

    // atributos del estudiante
    private Long id;
    private String nombre;
    private String correo;
    private String numeroTelefono;
    private String idioma;

    // Constructor vacio
    public Student() {
    }

    // Constructor con parametros
    public Student(String nombre, String correo, String numeroTelefono, String idioma) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.idioma = idioma;
    }

    // Constructor completo
    public Student(Long id, String nombre, String correo, String numeroTelefono, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.idioma = idioma;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return toString().equals(student.toString());
    }
}