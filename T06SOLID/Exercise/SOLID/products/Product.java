package T06SOLID.Exercise2.products;

public abstract class Product {
    private double caloriesBy100Gr;

    public abstract double getGrams();

    public void setCaloriesBy100Gr(double caloriesBy100Gr) {
        this.caloriesBy100Gr = caloriesBy100Gr;
    }

    public double calculateCalories() {
        return (this.caloriesBy100Gr / 100) * this.getGrams();
    }
}
