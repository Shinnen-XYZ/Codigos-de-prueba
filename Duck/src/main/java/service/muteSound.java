package service;
@lombok.ToString
public class muteSound implements SoundBehavior{
    public muteSound() {
    }
    @Override
    public void makeSound(){
        System.out.println("... ...");
    }
}
