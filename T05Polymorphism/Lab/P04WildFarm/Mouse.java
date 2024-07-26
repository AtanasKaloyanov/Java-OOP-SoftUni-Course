package T05Polymorphism.Lab.P04WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood() {
        System.out.println("Mices are not eating that type of food!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
