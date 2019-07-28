package ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String driveName = scan.nextLine();

        Car car = new Ferrari(driveName);
        System.out.println(car.toString());
    }
}
