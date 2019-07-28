package animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return this.name;
    }

    public String getFavouriteFood() {
        return this.favouriteFood;
    }

    protected abstract String explainSelf();

    @Override
    public String toString() {
        return String.format("I am %s and my favourite food is %s",
                this.getName(),
                this.getFavouriteFood());
    }
}
