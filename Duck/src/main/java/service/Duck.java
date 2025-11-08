package service;
@lombok.ToString
public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected SoundBehavior soundBehavior;

    public  abstract void display();

    public void swim(){
        System.out.println("nadar");
    }
    public void performfly(){
        flyBehavior.fly();
    }
    public void Quack(){
        soundBehavior.makeSound();
    }

}
