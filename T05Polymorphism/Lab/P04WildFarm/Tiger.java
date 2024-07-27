package T05Polymorphism.Lab.P04WildFarm;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            Integer foodQuantity = food.getQuantity();
            super.setFoodEaten(foodQuantity);
        } else {
            super.setFoodEaten(0);
            System.out.println("Tigers are not eating that type of food!");
        }
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
