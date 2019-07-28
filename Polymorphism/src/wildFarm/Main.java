package wildFarm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Mammal> mammals = new ArrayList<>();
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scan.nextLine().split("\\s+");

            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            double animalWeight = Double.parseDouble(animalInfo[2]);
            String animalLivingRegion = animalInfo[3];

            String foodType = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            if ("Vegetable".equals(foodType)) {
                Food vegetable = new Vegetable(foodQuantity);

                if ("Mouse".equals(animalType)) {
                    Mammal mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    mouse.makeSound();
                    mouse.eatFood(vegetable);
                    mammals.add(mouse);
                } else if ("Zebra".equals(animalType)) {
                    Mammal zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    zebra.makeSound();
                    zebra.eatFood(vegetable);
                    mammals.add(zebra);
                } else if ("Cat".equals(animalType)) {
                    Mammal cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalInfo[4]);
                    cat.makeSound();
                    cat.eatFood(vegetable);
                    mammals.add(cat);
                } else {
                    Mammal tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    tiger.makeSound();
                    mammals.add(tiger);
                    System.out.println("Tigers are not eating that type of food!");
                }
            } else {
                Food meat = new Meat(foodQuantity);

                if ("Tiger".equals(animalType)) {
                    Mammal tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    tiger.makeSound();
                    tiger.eatFood(meat);
                    mammals.add(tiger);
                } else if ("Cat".equals(animalType)) {
                    Mammal cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalInfo[4]);
                    cat.makeSound();
                    cat.eatFood(meat);
                    mammals.add(cat);
                } else if ("Mouse".equals(animalType)) {
                    Mammal mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    mouse.makeSound();
                    mammals.add(mouse);
                    System.out.println("Mice are not eating that type of food!");
                } else {
                    Mammal zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    zebra.makeSound();
                    mammals.add(zebra);
                    System.out.println("Zebras are not eating that type of food!");
                }
            }
        }

        mammals.forEach(mammal -> {
            String result;

            if (mammal instanceof Cat) {
                result = String.format("%s[%s, %s, %s, %s, %d]",
                        mammal.getAnimalType(),
                        mammal.getAnimalName(),
                        ((Cat) mammal).getBreed(),
                        new DecimalFormat("0.##").format(mammal.getAnimalWeight()),
                        mammal.getLivingRegion(),
                        mammal.getFoodEaten());
            } else {
                result = String.format("%s[%s, %s, %s, %d]",
                        mammal.getAnimalType(),
                        mammal.getAnimalName(),
                        new DecimalFormat("0.##").format(mammal.getAnimalWeight()),
                        mammal.getLivingRegion(),
                        mammal.getFoodEaten());
            }
            System.out.println(result);
        });
    }
}
