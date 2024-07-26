package T05Polymorphism.Lab.P04WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;
    public Mammal(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.##");
        String weightFormat = df.format(super.getAnimalWeight());
        return String.format("%s[%s, %s, %s, %d]", super.getAnimalType(), super.getAnimalName(),
                        weightFormat, this.getLivingRegion(),
                        super.getFoodEaten());

    }
}
