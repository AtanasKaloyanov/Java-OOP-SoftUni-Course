package T06SOLID.Exercise2.products;

public abstract class Food extends Product {
    private double grams;

    public Food(double grams) {
        this.grams = grams;
    }

    @Override
    public double getGrams() {
        return this.grams;
    }

}
