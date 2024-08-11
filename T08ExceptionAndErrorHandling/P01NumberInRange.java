package T08ExceptionAndErrorHandling;

import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        // 1. Interval reading and printing:
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int intervalBegin = Integer.parseInt(array[0]);
        int intervalEnd = Integer.parseInt(array[1]);
        System.out.printf("Range: [%d...%d]\n", intervalBegin, intervalEnd);

        // 2. Reading a line and printing a message in
        // try/catch/finally construction until a valid number is entered:
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String output = "";
            try {
                int number = Integer.parseInt(line);
                if (isInTheInterval(intervalBegin, intervalEnd, number)) {
                    throw new NumberFormatException();
                }
                output = String.format("Valid number: %d", number);
                return;
            } catch (NumberFormatException nfe) {
                output = String.format("Invalid number: %s", line);
            } finally {
                System.out.println(output);
            }
        }

    }

    private static boolean isInTheInterval(int intervalBegin, int intervalEnd, int number) {
        return (number < intervalBegin) || (number > intervalEnd);
    }
}
