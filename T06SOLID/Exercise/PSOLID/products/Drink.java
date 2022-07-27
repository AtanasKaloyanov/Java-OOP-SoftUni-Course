package T06SOLID.Exercise.PSOLID.products;

public abstract class Drink {
    private final double milliliter;
    private final double density;

    public Drink(double milliliter, double density) {
        this.milliliter = milliliter;
        this.density = density;
    }

    public double getMilliliter() {
        return this.milliliter;
    }

    public double getDensity() {
        return this.density;
    }

    double getDrinkAmountInLiters() {
        return 1000 / this.getMilliliter() * this.getDensity();
    }
}
