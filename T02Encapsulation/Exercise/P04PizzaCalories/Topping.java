package T02Encapsulation.Exercise.P04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
       setToppingType(toppingType);
       setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (toppingType.equals("Meat") || toppingType.equals("Veggies") || toppingType.equals("Cheese") ||  toppingType.equals("Sauce")) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories() {
        double toppingModifier = 0;

        if (this.toppingType.equals("Meat")) {
            toppingModifier = 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            toppingModifier = 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            toppingModifier = 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            toppingModifier = 0.9;
        }

        return 2 * this.weight * toppingModifier;
    }
}
