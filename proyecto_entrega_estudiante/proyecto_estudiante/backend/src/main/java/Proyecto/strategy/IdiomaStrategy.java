package Proyecto.strategy;

import Proyecto.model.Estudiante;

// Estrategia para normalizar y validar idioma
public interface IdiomaStrategy {
    // Aplica la lógica de idioma sobre el estudiante
    void aplicar(Estudiante estudiante);

    // Indica si esta estrategia acepta el valor dado
    boolean acepta(String idioma);
}

