package T06SOLID.Exercise.PSOLID.products;
public class Lemonade extends Drink implements Product {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    private double milliliters;

    public Lemonade(double milliliters) {
        super(DENSITY, milliliters);
    }

    @Override
    public double getAmountOfCalories() {
        double grams = getMilliliter() * DENSITY;
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }

}
