package T06SOLID.Exercise.PSOLID.products;

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

    @Override
    public  double getKg() {
        return (this.density / 1000) * this.density;
    }

}
