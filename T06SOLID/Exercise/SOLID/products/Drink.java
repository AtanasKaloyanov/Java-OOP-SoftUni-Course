package T06SOLID.Exercise2.products;

public abstract class Drink extends Product {
    private double milliliters;
    private double density;

    public Drink(double milliliters) {
        this.milliliters = milliliters;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public double getGrams() {
        return this.milliliters * this.density;
    }

}
