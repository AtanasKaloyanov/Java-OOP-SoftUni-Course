package T02Encapsulation.Exercise.P02AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading - name and age:
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        // 2. Creating an object of the class Chicken
        // and printing it:
        Chicken chicken = new Chicken(name, age);
        System.out.println(chicken);
    }
}
