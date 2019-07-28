package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] carInfo = scan.nextLine().split("\\s+");
        String[] truckInfo = scan.nextLine().split("\\s+");
        String[] busInfo = scan.nextLine().split("\\s+");

        try {
            Vehicle car = new Car(Double.parseDouble(carInfo[1]),
                    Double.parseDouble(carInfo[2]),
                    Double.parseDouble(carInfo[3]));
            Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]),
                    Double.parseDouble(truckInfo[2]),
                    Double.parseDouble(truckInfo[3]));
            Vehicle bus = new Bus(Double.parseDouble(busInfo[1]),
                    Double.parseDouble(busInfo[2]),
                    Double.parseDouble(busInfo[3]));

            int n = Integer.parseInt(scan.nextLine());

            while (n-- > 0) {
                String[] input = scan.nextLine().split("\\s+");

                switch (input[0]) {
                    case "DriveEmpty":
                    case "Drive":
                        double distance = Double.parseDouble(input[2]);

                        if ("Car".equals(input[1])) {
                            driveVehicle(car, distance, input[1]);
                        } else if ("Truck".equals(input[1])) {
                            driveVehicle(truck, distance, input[1]);
                        } else {
                            //changing fuelConsumption for a bus with people
                            bus.setFuelConsumptionPerKm(bus.getFuelConsumptionPerKm() + 1.4);
                            driveVehicle(bus, distance, input[1]);
                        }
                        break;
                    case "Refuel":
                        double fuelLiters = Double.parseDouble(input[2]);

                        if ("Car".equals(input[1])) {
                            refuelVehicle(car, fuelLiters);
                        } else if ("Truck".equals(input[1])) {
                            refuelVehicle(truck, fuelLiters);
                        } else {
                            refuelVehicle(bus, fuelLiters);
                        }
                        break;
                }
            }
            System.out.printf("Car: %.2f%n", car.getFuelQuantity());
            System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
            System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void refuelVehicle(Vehicle vehicle, double fuelLiters) {
        try {
            vehicle.refueling(fuelLiters);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void driveVehicle(Vehicle vehicle, double distance, String name) {
        try {
            vehicle.driving(distance);
            System.out.printf("%s travelled %s km%n", name,
                    new DecimalFormat("0.##").format(distance));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
