package T06SOLID.Exercise2.products;

public class Chocolate extends Food {
    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(grams);
        setCaloriesBy100Gr(CALORIES_PER_100_GRAMS);
    }

}
