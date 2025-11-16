package Proyecto.model;

public class Estudiante {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String idioma;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String correo, String telefono, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.idioma = idioma;
    }

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

    public String getTelefono() {
        return telefono;
    }

    // 🔧 aquí estaba el bug antes, ahora sí guarda el valor:
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
