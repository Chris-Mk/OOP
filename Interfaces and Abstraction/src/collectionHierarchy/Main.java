package collectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] items = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        for (String item : items) {
            System.out.print(addCollection.add(item) + " ");
        }
        System.out.println();

        for (String item : items) {
            System.out.print(addRemoveCollection.add(item) + " ");
        }
        System.out.println();

        for (String item : items) {
            System.out.print(myList.add(item) + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(myList.remove() + " ");
        }
        System.out.println();
    }
}
