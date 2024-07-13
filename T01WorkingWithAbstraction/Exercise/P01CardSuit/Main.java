package T01WorkingWithAbstraction.Exercise.P01CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Command reading:
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        // 2. Output printing - iterating over the enum values via .values,
        // getting the indices and the currentValue and printing:
        System.out.println("Card Suits:");
        for (Suit value : Suit.values()) {
            int index = value.ordinal();
            String currentSuit = value.name();
            System.out.printf("Ordinal value: %d; Name value: %s\n", index, currentSuit);
        }
    }
}
