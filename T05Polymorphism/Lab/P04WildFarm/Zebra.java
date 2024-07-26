package T05Polymorphism.Lab.P04WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood() {
             System.out.println("Zebras are not eating that type of food!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
