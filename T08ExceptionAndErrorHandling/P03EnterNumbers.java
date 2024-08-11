package T08ExceptionAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03EnterNumbers {
    public static void main(String[] args) {
        // 1. Input reading, parsing the input to integer. Then adding the element (if it is valid)
        // in a list until the size of a list is less than 10:
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int begin = 1;
        while (numbers.size() < 10) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number <= begin || number >= 100) {
                    throw new IndexOutOfBoundsException();
                }

                numbers.add(number);
                begin = number;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Number!");
            } catch (IndexOutOfBoundsException ioob) {
                System.out.printf("Your number is not in range %d - 100!\n", begin);
            }
        }

        // 2. Output printing:
        String numbersFormmatted = numbers.toString().replaceAll("[\\[\\]]", "");
        System.out.println(numbersFormmatted);
    }
}

