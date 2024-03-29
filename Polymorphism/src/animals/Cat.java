package animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.toString() +
                System.lineSeparator() +
                "MEEOW";
    }
}
