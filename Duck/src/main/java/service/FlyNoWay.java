package service;

public class FlyNoWay implements FlyBehavior{

    public FlyNoWay() {
    }
    @Override
    public void fly() {
        System.out.println("No puede volar");
    }
}
