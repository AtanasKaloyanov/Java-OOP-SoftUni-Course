package T06SOLID.Exercise.PSOLID.products;

public class Lemonade extends Coke {
    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(milliliters);
        super.setCaloriesBy100Gr(CALORIES_PER_100_GRAMS);
        super.setDensity(DENSITY);
    }
}
