package T01WorkingWithAbstraction.Exercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. Reading the rank and the suit of the card
        Rank rank = Rank.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        // 2. Creating a card object and power calculation:
        Card card = new Card(rank, suit);
        int totalPower = card.powerCalculation();

        // 3. Output printing:
        System.out.printf("Card name: %s of %s; Card power: %s", rank, suit, totalPower);

    }
}
