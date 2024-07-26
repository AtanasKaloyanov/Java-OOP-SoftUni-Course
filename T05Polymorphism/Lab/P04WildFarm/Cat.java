package T05Polymorphism.Lab.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood() {

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        String weightFormat = df.format(super.getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(),
                this.breed, weightFormat,
                super.getLivingRegion(), super.getFoodEaten());
    }
}

