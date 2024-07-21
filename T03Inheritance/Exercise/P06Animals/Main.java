package T03Inheritance.Exercise.P06Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading via while cycle until a command,
        // creating an object and printing it:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("Beast!")) {
            String className = line;
            String[] animalInfo = scanner.nextLine().split(" ");
            String animalName = animalInfo[0];
            int animalAge = Integer.parseInt(animalInfo[1]);
            String animalGender = animalInfo[2];

            Object object = null;
            switch (className) {
                case "Dog":
                    object = new Dog(animalName, animalAge, animalGender);
                    break;

                case "Cat":
                    object = new Cat(animalName, animalAge, animalGender);
                    break;

                case "Frog":
                    object = new Frog(animalName, animalAge, animalGender);
                    break;

                case "Kitten":
                    object = new Kitten(animalName, animalAge);
                    break;

                case "Tomcat":
                    object = new Tomcat(animalName, animalAge);
                    break;
            }

            System.out.println(object);
            line = scanner.nextLine();
        }
    }
}
