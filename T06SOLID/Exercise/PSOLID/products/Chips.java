package T06SOLID.Exercise.PSOLID.products;

public class Chips extends Food {
    private static final double CALORIES_BY_100_GRAMS = 529;


    public Chips(double grams) {
        super(grams);
        super.setCaloriesBy100Gr(CALORIES_BY_100_GRAMS);
    }
}
