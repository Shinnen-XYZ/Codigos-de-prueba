package service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Cafe extends PlantillaBebida {
    private String tipoCafe;

    public Cafe() {
        super();
        this.tipoCafe = "Arábica";
        this.temperatura = 93;
        this.tiempoPreparacion = 4;
    }

    public Cafe(String tipoCafe) {
        this();
        if (tipoCafe != null && !tipoCafe.trim().isEmpty()) {
            this.tipoCafe = tipoCafe;
        }
    }

    @Override
    protected void preparar() {
        System.out.println("Filtrando café " + tipoCafe + " a través del filtro");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando azúcar y leche");
    }

    @Override
    protected void agregarExtras() {
        System.out.println("Agregando una pizca de canela");
    }
}
