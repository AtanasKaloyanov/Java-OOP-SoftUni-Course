package T06SOLID.Exercise.PSOLID.products;

public abstract class Product {
    private double caloriesBy100Gr;

    public abstract double getGrams();

    public abstract double getKg();

    public void setCaloriesBy100Gr(double caloriesBy100Gr) {
        this.caloriesBy100Gr = caloriesBy100Gr;
    }

    public double calculateCalories() {
        return (this.caloriesBy100Gr / 100) * this.getGrams();
    }

    public double calculateAmountInKg() {
        return this.getKg();
    }
}
