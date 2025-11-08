package service;
@lombok.ToString
public class Quack implements SoundBehavior{
    public Quack() {
    }
    @Override
    public void makeSound(){
        System.out.println("Quack Quack");
    }
}
