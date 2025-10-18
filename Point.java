package service;

public class Point extends Shape {

    protected double x, y;
    public Point( double a, double b ){ setPoint( a, b ); }

    public void setPoint( double a, double b ) {
        x = a;
        y = b;
    }

    public double getX(){ return x; }
    public double getY(){ return y; }

    @Override
    public String getName(){
        return "punto"; }

    @Override
    public String toString(){ return "[" + x + ", " + y + "]"; }
}
