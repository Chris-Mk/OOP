package defineAnInterfacePerson;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //multipleImplementation();
        //birthdayCelebration();
        foodShortage();

    }

    private static void foodShortage() {
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] data = scan.nextLine().split("\\s+");

            if (data.length == 3) {
                rebels.add(new Rebel(data[0], Integer.parseInt(data[1]), data[2]));
            } else if (data.length == 4) {
                citizens.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]));
            }
        }

        String input;
        while (!"End".equals(input = scan.nextLine())) {
            String finalInput = input;
            citizens.stream()
                    .filter(citizen -> citizen.getName().equals(finalInput))
                    .forEach(Citizen::buyFood);

            rebels.stream()
                    .filter(rebel -> rebel.getName().equals(finalInput))
                    .forEach(Rebel::buyFood);
        }

        System.out.println(citizens.stream()
                .mapToInt(Citizen::getFood)
                .sum() + rebels.stream()
                .mapToInt(Rebel::getFood)
                .sum());
    }

    private static void birthdayCelebration() {
        Scanner scan = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        String input;
        while (!"End".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Citizen":
                    citizens.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]));
                    break;
                case "Robot":
                    robots.add(new Robot(data[1], data[2]));
                    break;
                case "Pet":
                    pets.add(new Pet(data[1], data[2]));
                    break;
            }
        }

        String specialYear = scan.nextLine();

//        citizens.stream()
//                .filter(citizen -> citizen.getBirthDate().endsWith(specialYear))
//                .forEach(citizen -> System.out.println(citizen.getBirthDate()));

        pets.stream()
                .filter(pet -> pet.getBirthDate().endsWith(specialYear))
                .forEach(pet -> System.out.println(pet.getBirthDate()));
    }

    private static void multipleImplementation() {
        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
            Method[] methods = Birthable.class.getDeclaredMethods();
            methods = Identifiable.class.getDeclaredMethods();

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();

//            Identifiable identifiable = new Citizen(name, age, id, birthDate);
//            Birthable birthable = new Citizen(name, age, id, birthDate);

            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName());
        }
    }
}
