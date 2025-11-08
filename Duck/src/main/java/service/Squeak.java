package service;
@lombok.ToString
public class Squeak implements SoundBehavior{
    public Squeak() {
    }
    @Override
    public void makeSound(){
        System.out.println("Squeak Squeak");
    }
}
