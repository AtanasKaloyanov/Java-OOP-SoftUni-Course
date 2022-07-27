package T06SOLID.Exercise.PSOLID.products;

public class Chocolate extends Food implements Product{

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    private double grams;

    public Chocolate(double grams) {
        super(grams);
        this.grams = grams;
    }

    @Override
    public double getAmountOfCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * this.getGrams();
    }

}

