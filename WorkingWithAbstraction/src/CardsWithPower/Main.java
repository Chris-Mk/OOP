package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rank = scan.nextLine();
        String suit = scan.nextLine();

        Card card = new Card(RankPower.valueOf(rank), SuitPower.valueOf(suit));
        int cardPower = card.getRankPower().getPower() + card.getSuitPower().getPower();
        System.out.println("Card name: " + card.getRankPower() + " of " + card.getSuitPower() + "; Card power: " + cardPower);
    }
}
