package T04InterfacesAndAbstraction.Exercise.P05Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Reading the numbers and urls arrays:
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = readList(scanner);
        List<String> urls = readList(scanner);

        // 2. Instantiating the class Smartphone:
        Smartphone smartphone = new Smartphone(numbers, urls);
        String numbersMessage = smartphone.call();
        String urlsMessage = smartphone.browse();

        // 3. Printing the messages:
        System.out.println(numbersMessage);
        System.out.println(urlsMessage);
    }

    private static List<String> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}
