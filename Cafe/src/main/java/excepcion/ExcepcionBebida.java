package excepcion;

public class ExcepcionBebida extends Exception {
    public ExcepcionBebida(String mensaje) {
        super(mensaje);
    }

    public ExcepcionBebida(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}