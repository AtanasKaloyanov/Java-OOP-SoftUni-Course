package T08ExceptionAndErrorHandling;

import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        // 1. Input reading and output printing:
        Scanner scanner = new Scanner(System.in);
        String result = "";
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 0) {
                throw new NumberFormatException();
            }

            double sqrt = Math.sqrt(number);
            result = String.format("%.2f", sqrt);
        } catch (NumberFormatException nfe) {
            result = "Invalid";
        } finally {
            System.out.println(result);
            System.out.println("Goodbye");
        }
    }
}
