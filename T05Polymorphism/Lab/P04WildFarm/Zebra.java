package T05Polymorphism.Lab.P04WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            Integer foodQuantity = food.getQuantity();
            super.setFoodEaten(foodQuantity);
        } else {
            super.setFoodEaten(0);
            System.out.println("Zebras are not eating that type of food!");
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
