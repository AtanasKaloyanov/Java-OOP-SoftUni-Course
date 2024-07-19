package T03Inheritance.Exercise.P01Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        // 2. Creating an object of type Child and printing it:
        Child child = new Child(name, age);
        System.out.println(child);
    }
}
