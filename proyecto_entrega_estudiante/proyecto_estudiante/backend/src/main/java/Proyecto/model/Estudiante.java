package Proyecto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estudiante {

    private Long id;
    private String nombre;
    private String correo;

    @JsonProperty("numero_telefono")
    private String numeroTelefono;

    private String idioma;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String correo, String numeroTelefono, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.idioma = idioma;
    }

    // Getters y Setters
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
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
