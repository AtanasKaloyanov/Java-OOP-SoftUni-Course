package T06SOLID.Exercise.PSOLID.products;

public class Chocolate extends Food {
    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(grams);
        super.setCaloriesBy100Gr(CALORIES_PER_100_GRAMS);
    }

}
