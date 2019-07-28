package animals;

public class Dog extends Animal {
    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.toString() +
                System.lineSeparator() +
                "DJAAF";
    }
}
