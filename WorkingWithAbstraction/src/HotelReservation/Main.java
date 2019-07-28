package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        StringBuilder builder = new StringBuilder();
        builder.append(input[3].charAt(0));

        if (!input[3].equals("VIP")) {
            for (int i = 1; i < input[3].length(); i++) {
                if (Character.isUpperCase(input[3].charAt(i))) {
                    builder.append("_");
                }
                builder.append(input[3].charAt(i));
            }
        } else {
            builder = new StringBuilder(input[3]);
        }

        Reservation reservation = new Reservation(Double.parseDouble(input[0]),
                Integer.parseInt(input[1]),
                Season.valueOf(input[2].toUpperCase()),
                Discount.valueOf(builder.toString().toUpperCase()));

        PriceCalculator calculator = new PriceCalculator(reservation);
        System.out.println(String.format("%.2f", calculator.getToTalPrice()));
    }
}
