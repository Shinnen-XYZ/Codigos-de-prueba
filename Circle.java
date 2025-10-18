package service;

public class Circle extends Point {
    protected double radius;

    public Circle() {
        //super( 0, 0 );
        //setRadius( 0 );
        this( 0, 0, 0);
    }

    public Circle( double r, double a, double b ){
        super( a, b );
        setRadius( r );
    }

    public void setRadius( double r ){
        radius = (r >= 0.0) ? r : 0.0;
        //if( r >= 0.0 ) radius = r; else radius = 0.0;
    }

    public double getRadius(){ return radius; }

    @Override
    public double area(){ return 3.14159 * radius * radius; }

    @Override
    public String getName(){ return "círculo"; }

    @Override
    public String toString() {
        return "Centro = " + super.toString() + "; Radio = " + radius;
    }
}