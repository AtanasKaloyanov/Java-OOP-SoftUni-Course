package T08ExceptionAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = range[0];
        int end = range[1];

        System.out.printf("Range: [%d...%d]%n", start, end);

        String input = scanner.nextLine();
        while (true) {
            try {
                int number = Integer.parseInt(input);
                if (number >= start && number <= end) {
                    System.out.printf("Valid number: %d%n", number);
                    return;
                }

            } catch (Exception exception) {

            }

            System.out.printf("Invalid number: %s%n", input);
            input = scanner.nextLine();
        }
    }
}
