package SingleInheritance;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();

        Puppy puppy = new Puppy();
        puppy.weep();
        puppy.bark();
        puppy.eat();
    }
}
