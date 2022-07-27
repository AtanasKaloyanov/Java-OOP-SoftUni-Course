package T06SOLID.Exercise.PSOLID.products;

public class Coke extends Drink implements Product{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(DENSITY, milliliters);
    }

    @Override
    public double getAmountOfCalories() {
        double grams = getMilliliter() * DENSITY;
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }

}
