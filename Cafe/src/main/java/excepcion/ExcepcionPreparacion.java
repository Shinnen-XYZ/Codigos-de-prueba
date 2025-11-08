package excepcion;

public class ExcepcionPreparacion extends ExcepcionBebida {
    public ExcepcionPreparacion(String mensaje) {
        super(mensaje);
    }

    public ExcepcionPreparacion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}