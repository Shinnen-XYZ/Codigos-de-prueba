package service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class ChocolateCaliente extends PlantillaBebida {
    private String tipoChocolate;
    private boolean conMalvaviscos;

    public ChocolateCaliente() {
        super();
        this.tipoChocolate = "Semiamargo";
        this.temperatura = 85;
        this.tiempoPreparacion = 5;
        this.conMalvaviscos = true;
    }

    public ChocolateCaliente(String tipoChocolate, boolean conMalvaviscos) {
        this();
        if (tipoChocolate != null && !tipoChocolate.trim().isEmpty()) {
            this.tipoChocolate = tipoChocolate;
        }
        this.conMalvaviscos = conMalvaviscos;
    }

    @Override
    protected void preparar() {
        System.out.println("Mezclando cacao " + tipoChocolate +
                " con leche caliente");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando crema batida");
    }

    @Override
    protected void agregarExtras() {
        if (conMalvaviscos) {
            System.out.println("Agregando malvaviscos");
        }
    }
}
