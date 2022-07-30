package T08ExceptionAndErrorHandling;

import java.util.Scanner;

public class P02SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = Integer.parseInt(scanner.nextLine());
            double root = Math.pow(number, 0.5);
            if (number >= 0) {
                System.out.printf("%.2f%n", root);
            } else {
                System.out.println("Invalid");
            }
        } catch (Exception e) {
            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }
    }
}
