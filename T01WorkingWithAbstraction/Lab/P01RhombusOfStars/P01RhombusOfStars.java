package T01WorkingWithAbstraction.Lab.P01RhombusOfStars;

import java.util.Scanner;

public class P01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int givenNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= givenNumber ; i++) {
            for (int j = 1; j <= givenNumber - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = givenNumber - 1; i > 0 ; i--) {
            for (int j = 1; j <= givenNumber - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
