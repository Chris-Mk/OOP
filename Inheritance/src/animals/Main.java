package animals;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();
        String input;

        while (!"Beast!".equals(input = scan.nextLine())) {
            String[] animalData = scan.nextLine().split("\\s+");
            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            switch (input) {
                case "Cat" -> animals.add(new Cat(name, age, gender));
                case "Dog" -> animals.add(new Dog(name, age, gender));
                case "Frog" -> animals.add(new Frog(name, age, gender));
                case "Kitten" -> animals.add(new Kitten(name, age));
                case "Tomcat" -> animals.add(new Tomcat(name, age));
            }
        }

        animals.forEach(animal -> System.out.println(animal.toString()));
    }
}
