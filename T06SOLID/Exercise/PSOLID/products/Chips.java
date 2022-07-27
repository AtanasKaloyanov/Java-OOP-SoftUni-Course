package T06SOLID.Exercise.PSOLID.products;

public class Chips extends Food implements Product{
    public static final double CALORIES_PER_100_GRAMS = 529.0;
    private final double grams;

    public Chips(double grams) {
        super(grams);
        this.grams = grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * this.getGrams();
    }

}

