package service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Limonada extends PlantillaBebida {
    private String nivelAzucar;
    private int cantidadHielo;

    public Limonada() {
        super();
        this.nivelAzucar = "Media";
        this.temperatura = 0;
        this.tiempoPreparacion = 2;
        this.cantidadHielo = 5;
    }

    public Limonada(String nivelAzucar, int cantidadHielo) {
        this();
        if (nivelAzucar != null && !nivelAzucar.trim().isEmpty()) {
            this.nivelAzucar = nivelAzucar;
        }
        this.cantidadHielo = cantidadHielo > 0 ? cantidadHielo : 5;
    }

    @Override
    protected void hervirAgua() {
        System.out.println("Usando agua fría a " + temperatura + "°C (sin hervir)");
    }

    @Override
    protected void preparar() {
        System.out.println("Exprimiendo limones frescos");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando " + nivelAzucar.toLowerCase() +
                " cantidad de azúcar");
    }

    @Override
    protected void agregarExtras() {
        System.out.println("Agregando " + cantidadHielo + " cubos de hielo");
    }
}
