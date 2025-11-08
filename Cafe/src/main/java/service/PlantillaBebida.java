package service;

import excepcion.ExcepcionTemperaturaInvalida;
import excepcion.ExcepcionPreparacion;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class PlantillaBebida {
    protected int temperatura;
    protected int tiempoPreparacion;

    public PlantillaBebida() {
        this.temperatura = 100;
        this.tiempoPreparacion = 5;
    }
    public final void prepararReceta() throws ExcepcionPreparacion {
        try {
            System.out.println("\n=== Iniciando preparación de bebida ===");
            hervirAgua();
            preparar();
            verterEnTaza();
            agregarCondimentos();
            agregarExtras();
            System.out.println("=== Bebida lista para servir ===\n");
        } catch (Exception e) {
            throw new ExcepcionPreparacion("Error durante la preparación", e);
        }
    }
    protected void hervirAgua() throws ExcepcionTemperaturaInvalida {
        if (temperatura < 0 || temperatura > 100) {
            throw new ExcepcionTemperaturaInvalida(
                    "Temperatura inválida: " + temperatura + "°C"
            );
        }
        System.out.println("Hirviendo agua a " + temperatura + "°C");
    }
    protected final void verterEnTaza() {
        System.out.println("Vertiendo en la taza");
    }
    protected abstract void preparar();
    protected abstract void agregarCondimentos();
    protected void agregarExtras() {

    }
}