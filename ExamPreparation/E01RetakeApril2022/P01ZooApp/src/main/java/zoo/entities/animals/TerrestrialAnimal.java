package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    public static final double TERRESTRIAL_ANIMAL_KG = 5.5;
    public static final double TERRESTRIAL_ANIMAL_INCREASED_KG = 5.7;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, TERRESTRIAL_ANIMAL_KG, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + TERRESTRIAL_ANIMAL_INCREASED_KG);
    }


}
