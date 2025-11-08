package service;

import lombok.Getter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@ToString
@AllArgsConstructor
public class Ingrediente<T> {
    private String nombre;
    private T cantidad;
    private String unidad;
}