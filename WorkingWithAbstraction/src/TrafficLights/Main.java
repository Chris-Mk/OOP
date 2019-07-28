package TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < input.length; j++) {
                input[j] = changeColor(input[j]);
            }
            System.out.println(Arrays.toString(input).replaceAll("[\\[\\],]", ""));
        }
    }

    private static String changeColor(String color) {
        if ("RED".equals(color)) {
            color = "GREEN";
        } else if ("GREEN".equals(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equals(color)){
            color = "RED";
        }
        return color;
    }
}
