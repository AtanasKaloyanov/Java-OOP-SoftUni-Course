package T05Polymorphism.Lab.P04WildFarm;

public class Tiger extends Feline {
    public Tiger(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood() {
        System.out.println("Tigers are not eating that type of food!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
