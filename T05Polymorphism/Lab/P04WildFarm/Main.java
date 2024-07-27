package T05Polymorphism.Lab.P04WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading via while cycle until "End" command:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!line.equals("End")) {
            // 1.1. Animal fields reading:
            String[] animalInfo = line.split(" ");
            String animalType = animalInfo[0];
            String animalName = animalInfo[1];
            Double animalWeight = Double.parseDouble(animalInfo[2]);
            String livingRegion = animalInfo[3];

            // 1.2. Creating an animal via Polymorphism:
            Animal animal = createAnimal(animalInfo, animalType,
                    animalName, animalWeight, livingRegion);

            // 1.3. Food fields reading:
            String[] foodInfo = scanner.nextLine().split(" ");
            String foodType = foodInfo[0];
            Integer foodEaten = Integer.parseInt(foodInfo[1]);
            Food food = initializeFood(foodType, foodEaten);

            // 1.4. makeSound(), eatFoot(Foot foot) and adding the currentAnimal into a list.
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            line = scanner.nextLine();
        }

        // 2. Animals printing:
        animals.forEach(System.out::println);
    }

    private static Animal createAnimal(String[] animalInfo, String animalType, String animalName, Double animalWeight, String livingRegion) {
        Animal animal = null;
        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                break;
            case "Cat":
                String animalBreed = animalInfo[4];
                animal = new Cat(animalName, animalType, animalWeight,
                        livingRegion, animalBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType,
                        animalWeight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType,
                        animalWeight, livingRegion);
                break;
        }
        return animal;
    }

    private static Food initializeFood(String foodType, Integer foodEaten) {
        Food food = null;
        if (foodType.equals("Meat")) {
            food = new Meat(foodEaten);
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable(foodEaten);
        }
        return food;
    }
}

/*

Cat Jerry 0.521 Anywhere A
Vegetable 0
Tiger Tom 167.7 Asia
Vegetable 1
End

 */
