package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Identifiable> visitors = new ArrayList<>();

        String input;
        while (!"End".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            if (data.length == 2) {
                visitors.add(new Robot(data[0], data[1]));
            } else if (data.length == 3) {
                visitors.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));
            }
        }

        String fakeId = scan.nextLine();
//        visitors.stream()
//                .filter(visitor -> !visitor.getId().endsWith(fakeId))
//                .forEach(visitor -> System.out.println(visitor.getId()));

        for (Identifiable visitor : visitors) {
            if (visitor.getId().endsWith(fakeId)) {
                System.out.println(visitor.getId());
            }
        }
    }
}
