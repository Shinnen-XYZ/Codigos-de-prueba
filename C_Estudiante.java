package service;

public class C_Estudiante {
    int carnet;

    public C_Estudiante(int carnet) {
        this.carnet = carnet;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "C_Estudiante{carnet=" + carnet + "}";
    }
}
