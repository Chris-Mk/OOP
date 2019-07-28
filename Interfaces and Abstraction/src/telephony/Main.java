package telephony;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split("\\s+");
        String[] websites = scan.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(Arrays.asList(numbers), Arrays.asList(websites));

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
