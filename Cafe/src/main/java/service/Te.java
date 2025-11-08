package service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Te extends PlantillaBebida {
    private String tipoTe;
    private int tiempoInfusion;

    public Te() {
        super();
        this.tipoTe = "Verde";
        this.temperatura = 80;
        this.tiempoPreparacion = 3;
        this.tiempoInfusion = 3;
    }

    public Te(String tipoTe) {
        this();
        if (tipoTe != null && !tipoTe.trim().isEmpty()) {
            this.tipoTe = tipoTe;
        }
        this.tiempoInfusion = tipoTe.equalsIgnoreCase("Negro") ? 5 : 3;
    }

    @Override
    protected void preparar() {
        System.out.println("Remojando bolsa de té " + tipoTe +
                " durante " + tiempoInfusion + " minutos");
    }

    @Override
    protected void agregarCondimentos() {
        System.out.println("Agregando limón");
    }

    @Override
    protected void agregarExtras() {
        System.out.println("Agregando miel al gusto");
    }
}
