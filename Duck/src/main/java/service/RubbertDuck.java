package service;

@lombok.ToString
public class RubbertDuck extends Duck{
    public RubbertDuck() {
        flyBehavior = new FlyNoWay();
        soundBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("squeak");
    }
}
