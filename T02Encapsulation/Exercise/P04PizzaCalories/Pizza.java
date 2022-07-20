package T02Encapsulation.Exercise.P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setToppings(int number) {
        if (number >= 0 && number <= 10) {
            this.toppings = new ArrayList<>(number);
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private void setName(String name) {
        if (name.trim().length() >= 1 && name.trim().length() <= 15) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {

        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(e -> e.calculateCalories()).sum();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, getOverallCalories());
    }
}
