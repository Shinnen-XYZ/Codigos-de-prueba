package Proyecto.strategy;

public class IdiomaStrategyFactory {

    public IdiomaStrategy obtenerEstrategia(String idiomaTexto) {

        IdiomaStrategy[] estrategias = new IdiomaStrategy[] {
                new EspanolStrategy(),
                new InglesStrategy(),
                new FrancesStrategy()
        };

        for (IdiomaStrategy estrategia : estrategias) {
            if (estrategia.acepta(idiomaTexto)) {
                return estrategia;
            }
        }

        throw new IllegalArgumentException("El idioma debe ser español, inglés o francés");
    }
}

