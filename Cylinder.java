package service;

class Cylinder extends Circle {

    protected double height;

    public Cylinder( double h, double r, double a, double b ) {
        this( 0, 0, 0);
        setHeight( h );
    }

    public Cylinder() {
        this( 0, 0, 0 );
    }

    public Cylinder(int i, int i1, int i2) {
    }

    public void setHeight( double h ){
        height = (h >= 0.0) ? h : 0.0;
    }

    public double getHeight(){ return height; }

    //superficial
    @Override
    public double area() {
        return 2 * 3.14159 * radius ( radius + height );
    }

    private int radius(double v){
        return 0;
    }

    @Override
    public double volume(){ return super.area() * height; }

    @Override
    public String getName(){ return "cilindro"; }

    public String toString() {
        return "Círculo = {" + super.toString() + "}; Altura = " + height;
    }
}