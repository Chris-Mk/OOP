import java.util.Scanner;

public class RhombusOfStar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        //prints the upper part and the middle row
        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n - i) + "* ".repeat(i).trim());
        }

        //prints the bottom part
        for (int i = 1; i <= n - 1; i++) {
            System.out.println(" ".repeat(i) + "* ".repeat(n - i).trim());
        }
    }
}
