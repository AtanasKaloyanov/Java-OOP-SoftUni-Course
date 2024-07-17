package T02Encapsulation.Exercise.P04PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        // 1. Meat, 2. Veggies, 3. Cheese, or 4. Sauce
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException(String.format(
                    "Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(String.format(
                    "%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    // 1. Meat - 1.2;
    // 2. Veggies - 0.8;
    // 3. Cheese - 1.1;
    // 4. Sauce - 0.9;
    private double toppCoef() {
        double toppCoef = 0;
        switch (this.toppingType) {
            case "Meat":
                toppCoef = 1.2;
                break;
            case "Veggies":
                toppCoef = 0.8;
                break;
            case "Cheese":
                toppCoef = 1.1;
                break;
            case "Sauce":
                toppCoef = 0.9;
                break;
        }
        return toppCoef;
    }

    public double calculateCalories() {
        return 2 * this.weight * toppCoef();
    }
}
