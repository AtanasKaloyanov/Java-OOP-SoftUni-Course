package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
    public static final double AQUATIC_ANIMAL_KG = 2.5;
    public static final double AQUATIC_ANIMAL_INCREASED_KG = 7.5;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, AQUATIC_ANIMAL_KG, price);
    }

    @Override
    public void eat() {
        setKg(getKg() + AQUATIC_ANIMAL_INCREASED_KG);
    }


}
