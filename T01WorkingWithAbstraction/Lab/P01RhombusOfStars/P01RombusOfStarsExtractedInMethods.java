package T01WorkingWithAbstraction.Lab.P01RhombusOfStars;

import java.util.Scanner;

public class P01RombusOfStarsExtractedInMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int givenNumber = Integer.parseInt(scanner.nextLine());

        printTopHalf(givenNumber);

        printBottomHalf(givenNumber);
    }


    private static void printBottomHalf(int givenNumber) {
        for (int i = givenNumber - 1; i > 0 ; i--) {
            printRow(givenNumber, i);
        }
    }

    private static void printTopHalf(int givenNumber) {
        for (int i = 1; i <= givenNumber; i++) {
            printRow(givenNumber, i);
        }
    }


    private static void printRow(int givenNumber, int i) {
        for (int j = 1; j <= givenNumber - i ; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i - 1 ; j++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
