package T04InterfacesAndAbstraction.Exercise.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading via while cycle, Citizen and Pet object creating
        // and adding then into a list:
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String creature = data[0];

            switch (creature) {
                case "Citizen":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthDate = data[4];
                    Birthable human = new Citizen(name, age, id, birthDate);
                    birthableList.add(human);
                    break;

                case "Pet":
                    String petName = data[1];
                    String petBirthDay = data[2];
                    Birthable pet = new Pet(petName, petBirthDay);
                    birthableList.add(pet);
            }

            input = scanner.nextLine();
        }

        // 2. Reading a String, iterating over the collection and if the current
        // object's birthday field ends with the String => printing the birthday.
        // If there isn't such an object => printing a message
        String searchedBirthday = scanner.nextLine();
        boolean matchedBirthdays = false;

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(searchedBirthday)) {
                System.out.println(birthable.getBirthDate());
                matchedBirthdays = true;
            }
        }

        if (!matchedBirthdays) {
            System.out.println("<no output>");
        }
    }
}

