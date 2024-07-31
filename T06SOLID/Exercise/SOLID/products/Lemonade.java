package T06SOLID.Exercise2.products;

public class Lemonade extends Coke {
    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(milliliters);
        setCaloriesBy100Gr(CALORIES_PER_100_GRAMS);
        setDensity(DENSITY);
    }
}
