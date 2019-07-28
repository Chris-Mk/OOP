package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] people = scan.nextLine().split(";");
        Map<String, Double> peopleWithMoney = new HashMap<>();
        for (String person : people) {
            String[] personInfo = person.split("=");
            peopleWithMoney.put(personInfo[0], Double.parseDouble(personInfo[1]));
        }

        String[] products = scan.nextLine().split(";");
        Map<String, Double> productsWithCost = new LinkedHashMap<>();
        for (String product : products) {
            String[] productInfo = product.split("=");
            productsWithCost.put(productInfo[0], Double.parseDouble(productInfo[1]));
        }

        List<Person> peopleWithProducts = new ArrayList<>();

        String input;
        while (!"END".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            try {
                Product product = new Product(productName, productsWithCost.get(productName));
                boolean isPersonPresent = false;

                for (Person person : peopleWithProducts) {
                    if (person.getName().equals(personName)) {
                        try {
                            person.buyProduct(product);
                            isPersonPresent = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    }
                }

                if (!isPersonPresent) {
                    try {
                        Person person = new Person(personName, peopleWithMoney.get(personName));
                        try {
                            person.buyProduct(product);
                            peopleWithProducts.add(person);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        peopleWithProducts.forEach(person -> System.out.println(person.toString()));
    }
}
