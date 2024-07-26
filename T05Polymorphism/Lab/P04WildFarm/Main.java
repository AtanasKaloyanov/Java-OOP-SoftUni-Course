package T05Polymorphism.Lab.P04WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading via while cycle until "?nd" command:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            // 1.1. Animal fields reading:
            String[] animalInfo = line.split(" ");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            // 1.2. Food fields reading:
            String[] foodInfo = scanner.nextLine().split(" ");
            String foodType = foodInfo[0];
            Integer foodEaten = Integer.parseInt(foodInfo[1]);
            // 1.3. Creating an animal via Polymorphism:
            Animal animal = null;

            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight,
                            foodEaten, livingRegion);
                    animal.makeSound();
                    if (!foodType.equals("Vegetable")) {
                        animal.setFoodEaten(0);
                        animal.eatFood();
                    }
                    break;
                case "Cat":
                    String animalBreed = animalInfo[4];
                    animal = new Cat(animalName, animalType, animalWeight,
                            foodEaten, livingRegion, animalBreed);
                    animal.makeSound();
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight,
                            foodEaten, livingRegion);
                    animal.makeSound();
                    if (!foodType.equals("Meet")) {
                        animal.setFoodEaten(0);
                        animal.eatFood();
                    }
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight,
                            foodEaten, livingRegion);
                    animal.makeSound();
                    if (!foodType.equals("Vegetable")) {
                        animal.setFoodEaten(0);
                        animal.eatFood();
                    }
                    break;
            }

            System.out.println(animal);
            line = scanner.nextLine();
        }
    }
}

/*
Tiger Tom 167.7 Asia
Vegetable 1
Cat Gray 1.1 Home Persian
Vegetable 4
End
 */
