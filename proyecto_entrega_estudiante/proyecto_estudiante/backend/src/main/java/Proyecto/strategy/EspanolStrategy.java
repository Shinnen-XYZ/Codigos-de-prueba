package Proyecto.strategy;

import Proyecto.model.Estudiante;

public class EspanolStrategy implements IdiomaStrategy {

    @Override
    public void aplicar(Estudiante estudiante) {
        estudiante.setIdioma("español");
    }

    @Override
    public boolean acepta(String idioma) {
        if (idioma == null) return false;
        String i = idioma.toLowerCase();
        return i.contains("espa");
    }
}


