package service;
@lombok.ToString
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FLyWithWings();
        soundBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("quak");
    }

}
