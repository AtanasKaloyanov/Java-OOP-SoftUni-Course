package T01WorkingWithAbstraction.Lab.P03StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an object of type Student System
        StudentSystem studentSystem = new StudentSystem();

        // 2. Commands implementation:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("Exit")) {
            String[] array = line.split(" ");
            String command = array[0];
            String name = array[1];
            if (command.equals("Create")) {
                int age = Integer.parseInt(array[2]);
                double grade = Double.parseDouble(array[3]);
                studentSystem.addStudent(name, age, grade);
            } else if (command.equals("Show")) {
                studentSystem.printStudent(name);
            }

            line = scanner.nextLine();
        }

    }
}
