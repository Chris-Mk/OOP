package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaInput = scan.nextLine().split("\\s+");
        try {
            Pizza pizza = new Pizza(pizzaInput[1], Integer.parseInt(pizzaInput[2]));

            String[] doughInput = scan.nextLine().split("\\s+");
            try {
                pizza.setDough(new Dough(doughInput[1], doughInput[2], Double.parseDouble(doughInput[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            String input;
            while (!"END".equals(input = scan.nextLine())) {
                String[] toppingsInput = input.split("\\s+");

                try {
                    pizza.addTopping(new Topping(toppingsInput[1], Double.parseDouble(toppingsInput[2])));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }

            System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getOverallCalories()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
