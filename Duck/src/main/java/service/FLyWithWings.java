package service;


@lombok.ToString
public class FLyWithWings implements FlyBehavior{

    public FLyWithWings(){
    }
    @Override
    public void fly() {
        System.out.println("Puedo volar");
    }
}
