package wildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        this.setFoodEaten(food.getQuantity());
    }
}
