package service;
@lombok.ToString
public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        flyBehavior = new FLyWithWings();
        soundBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("quak");
    }

}
