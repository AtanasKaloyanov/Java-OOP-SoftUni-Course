package T01WorkingWithAbstraction.Exercise.P02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Command reading:
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        // 2. Iterating over the enum values and printing the
        // current index and the value itself:
        System.out.println(command + ":");
        for (Rank value : Rank.values()) {
            int index = value.ordinal();
            String name = value.name();
            System.out.printf("Ordinal value: %d; Name value: %s\n", index, name);
        }
    }
}
