package T06SOLID.Exercise.PSOLID.products;

public abstract class Food extends Product {
    private double grams;

    public Food(double grams) {
        this.grams = grams;
    }

    @Override
    public double getGrams() {
        return this.grams;
    }

    @Override
    public  double getKg() {
        return this.grams / 1000;
    }
}
