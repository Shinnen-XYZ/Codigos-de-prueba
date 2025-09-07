package service;

public class C_Estudiante {
    private int carnet;

    public C_Estudiante(){
        this.carnet = 0;
    }

    public C_Estudiante(int carnet){
        this.carnet = carnet;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String toString(){
        return "C_Estudiante{carnet=" + carnet + "}";
    }
}

class MyException extends Exception {
    
    public MyException(String mensaje) {
        super(mensaje);
    }
    
    public String toString() {
        return "MyException: " + getMessage();
    }
}
