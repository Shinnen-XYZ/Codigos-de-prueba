package Proyecto.strategy;

import Proyecto.model.Estudiante;

public interface IdiomaStrategy {
    void aplicar(Estudiante estudiante);
    boolean acepta(String idioma);
}


